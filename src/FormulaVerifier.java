import javax.swing.*;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaVerifier extends InputVerifier {
    /**
     * Checks whether the JComponent's input is valid. This method should
     * have no side effects. It returns a boolean indicating the status
     * of the argument's input.
     *
     * @param input the JComponent to verify
     * @return <code>true</code> when valid, <code>false</code> when invalid
     * @see JComponent#setInputVerifier
     * @see JComponent#getInputVerifier
     */
    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField)input).getText();

        if (text.equals("")) {
            return true;
        }

        text = text.toUpperCase(Locale.ROOT);

        if (text.equals("G")) {
            return true;
        }

        String[] regexTestStrings = {
                "^[*XD][-+]?\\d*\\.?\\d*$",
                "^[-+]\\d*\\.?\\d*$",
                "^GP[-+]?\\d*\\.?\\d*$",
        };

        for (String testString : regexTestStrings) {
            Pattern pattern = Pattern.compile(testString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            boolean matchFound = matcher.find();
            if(matchFound) {
                return true;
            }
        }
        return false;
    }
}
