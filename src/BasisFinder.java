import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BasisFinder extends JPanel {
    JLabel unitPriceLabel;
    JLabel formulaLabel;
    JLabel decimalsLabel;
    JLabel basisValueLabel;

    JTextField unitPriceTextField;
    JTextField formulaTextField;
    JTextField basisValueTextField;

    JComboBox<String> decimalsCombobox;

    JButton copyButton;


    BasisFinder() {

        this.setName("Basis Finder");

        unitPriceLabel = new JLabel("Unit Price");
        formulaLabel = new JLabel("Formula");
        decimalsLabel = new JLabel("Decimals");
        basisValueLabel = new JLabel("Basis Value");

        unitPriceTextField = new JTextField(10);
        formulaTextField = new FormulaTextField(10);
        basisValueTextField = new JTextField(10);

        String[] comboBoxItems = {"Auto", "0", "1", "2", "3", "4", "5", "6"};
        decimalsCombobox = new JComboBox<>(comboBoxItems);

        copyButton = new JButton("Copy");
        copyButton.setMargin(new Insets(0, 2, 0, 2));

        addComponentsToFrame();
        setUpFieldVerifiers();
    }

    public void setUpFieldVerifiers() {
        unitPriceTextField.setInputVerifier(new NumberVerifier());
        formulaTextField.setInputVerifier(new FormulaVerifier());
    }

    public void addComponentsToFrame() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(2, 2, 2, 2);

        c.gridx = 0;
        c.gridy = 0;
        this.add(unitPriceLabel, c);
        c.gridx = 1;
        this.add(unitPriceTextField, c);
        c.gridx = 3;
        this.add(basisValueLabel, c);
        c.gridx = 4;
        this.add(basisValueTextField, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(formulaLabel, c);
        c.gridx = 1;
        this.add(formulaTextField, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(decimalsLabel, c);
        c.gridx = 1;
        this.add(decimalsCombobox, c);


        c.gridy = 0;
        c.gridx = 5;
        this.add(copyButton, c);
        this.setBorder(new EmptyBorder(10,10,10,10));

        // add the separator
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 3;
        c.fill = GridBagConstraints.VERTICAL;
        this.add(new JSeparator(SwingConstants.VERTICAL), c);

    }
}
