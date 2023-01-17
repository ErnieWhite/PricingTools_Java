import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FormulaDocumentFilter extends DocumentFilter {
    FormulaPartialVerifier formulaPartialVerifier = new FormulaPartialVerifier();
    public void insertString(
            FilterBypass fb,
            int offset,
            String text,
            AttributeSet attr
    ) throws BadLocationException {

        fb.insertString(offset, FormulaPartialVerifier.verify(text).toUpperCase(), attr);
    }

    public void replace(
            FilterBypass fb,
            int offset,
            int length,
            String text,
            AttributeSet attrs
    ) throws BadLocationException {
        fb.replace(offset, length, FormulaPartialVerifier.verify(text).toUpperCase(), attrs);
    }
}
