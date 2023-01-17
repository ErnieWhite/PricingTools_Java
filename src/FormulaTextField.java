import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FormulaTextField extends JTextField {
    public FormulaTextField(int cols) {
        super(cols);

        FormulaTextField myFormulaTextField = this;
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                restrictText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                restrictText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                restrictText();
            }
            public void restrictText() {
                myFormulaTextField.setText(FormulaPartialVerifier.verify(myFormulaTextField.getText()));
            }
        });
    }
}
