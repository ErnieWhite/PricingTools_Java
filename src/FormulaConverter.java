import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FormulaConverter extends JPanel {
    JLabel formulaLabel, decimalsLabel;
    JLabel multiplierLabel, discountLabel, markupLabel, grossProfitLabel;
    JTextField formulaTextField, multiplierTextField, discountTextField, markupTextField, grossProfitTextField;
    JComboBox<String> decimalsComboBox;
    JButton multiplierCopyButton, discountCopyButton, markupCopyButton, grossProfitCopyButton;

    FormulaConverter() {
        this.setName("Formula Converter");
        formulaLabel = new JLabel("Formula");
        decimalsLabel = new JLabel("Decimals");

        multiplierLabel = new JLabel("Multiplier");
        discountLabel = new JLabel("Discount");
        markupLabel = new JLabel("Markup");
        grossProfitLabel = new JLabel("Gross Profit");

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
        multiplierCopyButton.setMargin(new Insets(0, 2, 0, 2));
        discountCopyButton.setMargin(new Insets(0, 2, 0, 2));
        markupCopyButton.setMargin(new Insets(0, 2, 0, 2));
        grossProfitCopyButton.setMargin(new Insets(0, 2, 0, 2));

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
        this.add(formulaLabel, c);
        c.gridx = 1;
        this.add(formulaTextField, c);
        c.gridx = 3;
        this.add(multiplierLabel, c);
        c.gridx = 4;
        this.add(multiplierTextField, c);
        c.gridx = 5;
        this.add(multiplierCopyButton, c);

        // add the decimals row
        c.gridy = 1;
        c.gridx = 0;
        this.add(decimalsLabel, c);
        c.gridx = 1;
        this.add(decimalsComboBox, c);
        c.gridx = 3;
        this.add(discountLabel, c);
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
        this.add(markupLabel, c);
        c.gridx = 4;
        this.add(markupTextField, c);
        c.gridx = 5;
        this.add(markupCopyButton, c);

        // add the gross profit row
        c.gridy = 3;
        c.gridx = 3;
        this.add(grossProfitLabel, c);
        c.gridx = 4;
        this.add(grossProfitTextField, c);
        c.gridx = 5;
        this.add(grossProfitCopyButton, c);

        this.setBorder(new EmptyBorder(10, 10, 10, 10));
    }
}
