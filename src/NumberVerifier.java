import javax.swing.*;

public class NumberVerifier extends InputVerifier {
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
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
