import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaPartialVerifier {
    /**
     * Returns the correct starting portion of a formula. This method should
     * have no side effects.
     *
     * @param input the formula to verify
     * @return the correct starting part of the formula
     */

    public static String verify(String input) {

        if (input.equals("")) {
            return input;
        }

        String text = input.toUpperCase(Locale.ROOT);

        if (text.equals("G")) {
            return text;
        }

        String[] regexTestStrings = {
                "^[*XD][-+]?\\d*\\.?\\d*",
                "^[-+]\\d*\\.?\\d*",
                "^GP[-+]?\\d*\\.?\\d*",
        };

        for (String testString : regexTestStrings) {
            Pattern pattern = Pattern.compile(testString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            boolean matchFound = matcher.find();
            if(matchFound) {
                return matcher.group(0);
            }
        }
        return "";
    }
}
