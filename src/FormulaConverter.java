import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FormulaConverter extends JPanel {
    JTextField formulaTextField;
    JTextField multiplierTextField;
    JTextField discountTextField;
    JTextField markupTextField;
    JTextField grossProfitTextField;
    JComboBox<String> decimalsComboBox;
    JButton multiplierCopyButton;
    JButton discountCopyButton;
    JButton markupCopyButton;
    JButton grossProfitCopyButton;

    FormulaConverter() {
        this.setName("Formula Converter");

        formulaTextField = new JTextField(10);
        multiplierTextField = new JTextField(10);
        discountTextField = new JTextField(10);
        markupTextField = new JTextField(10);
        grossProfitTextField = new JTextField(10);

        String[] comboBoxItems = {"Auto", "0", "1", "2", "3", "4", "5", "6"};
        decimalsComboBox = new JComboBox<>(comboBoxItems);

        multiplierCopyButton = new JButton("Copy");
        discountCopyButton = new JButton("Copy");
        markupCopyButton = new JButton("Copy");
        grossProfitCopyButton = new JButton("Copy");
        Insets insets = new Insets(0, 2, 0, 2);
        multiplierCopyButton.setMargin(insets);
        discountCopyButton.setMargin(insets);
        markupCopyButton.setMargin(insets);
        grossProfitCopyButton.setMargin(insets);

        addComponentsToFrame();
        setUpFieldValidators();

    }

    public void setUpFieldValidators() {
        formulaTextField.setInputVerifier(new FormulaVerifier());
    }

    public void addComponentsToFrame() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // add the formula row
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(2, 2, 2, 2);

        c.gridy = 0;
        c.gridx = 0;
        this.add(new JLabel("Formula"), c);
        c.gridx = 1;
        this.add(formulaTextField, c);
        c.gridx = 3;
        this.add(new JLabel("Multiplier"), c);
        c.gridx = 4;
        this.add(multiplierTextField, c);
        c.gridx = 5;
        this.add(multiplierCopyButton, c);

        // add the decimals row
        c.gridy = 1;
        c.gridx = 0;
        this.add(new JLabel("Decimals"), c);
        c.gridx = 1;
        this.add(decimalsComboBox, c);
        c.gridx = 3;
        this.add(new JLabel("Discount"), c);
        c.gridx = 4;
        this.add(discountTextField, c);
        c.gridx = 5;
        this.add(discountCopyButton, c);

        // add the separator
        c.gridy = 0;
        c.gridx = 2;
        c.gridheight = 4;
        c.fill = GridBagConstraints.VERTICAL;
        this.add(new JSeparator(SwingConstants.VERTICAL), c);

        // add the markup row
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridy = 2;
        c.gridx = 3;
        this.add(new JLabel("Markup"), c);
        c.gridx = 4;
        this.add(markupTextField, c);
        c.gridx = 5;
        this.add(markupCopyButton, c);

        // add the gross profit row
        c.gridy = 3;
        c.gridx = 3;
        this.add(new JLabel("Gross Profit"), c);
        c.gridx = 4;
        this.add(grossProfitTextField, c);
        c.gridx = 5;
        this.add(grossProfitCopyButton, c);

        this.setBorder(new EmptyBorder(10, 10, 10, 10));
    }
}
