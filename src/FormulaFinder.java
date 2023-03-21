import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class FormulaFinder extends JPanel {
    JTextField unitPriceTextField;
    JTextField basisValueTextField;
    JComboBox<String> decimalsComboBox;

    JTextField multiplierFormulaTextField;
    JTextField discountFormulaTextField;
    JTextField markupFormulaTextField;
    JTextField grossProfitFormulaTextField;

    JButton multiplierFormulaCopyButton;
    JButton discountFormulaCopyButton;
    JButton markupFormulaCopyButton;
    JButton grossProfitFormulaCopyButton;


    FormulaFinder() {
        this.setName("Formula Finder");

        this.unitPriceTextField = new JTextField(10);
        this.basisValueTextField = new JTextField(10);
        String[] comboBoxItems = {"Auto", "0", "1", "2", "3", "4", "5", "6"};
        this.decimalsComboBox = new JComboBox<>(comboBoxItems);
        decimalsComboBox.setSize(20,10);

        multiplierFormulaTextField = new JTextField(10);
        discountFormulaTextField = new JTextField(10);
        markupFormulaTextField = new JTextField(10);
        grossProfitFormulaTextField = new JTextField(10);

        multiplierFormulaCopyButton = new JButton("Copy");
        discountFormulaCopyButton = new JButton("Copy");
        markupFormulaCopyButton = new JButton("Copy");
        grossProfitFormulaCopyButton = new JButton("Copy");

        multiplierFormulaCopyButton.setMargin(new Insets(0, 2, 0, 2));
        discountFormulaCopyButton.setMargin(new Insets(0, 2, 0, 2));
        markupFormulaCopyButton.setMargin(new Insets(0, 2, 0, 2));
        grossProfitFormulaCopyButton.setMargin(new Insets(0, 2, 0, 2));

        addComponentsToFrame();
        setUpFieldValidators();
        addDocumentListeners();

    }

    public void addDocumentListeners() {

    }

    public void setUpFieldValidators() {
        unitPriceTextField.setInputVerifier(new NumberVerifier());
        basisValueTextField.setInputVerifier(new NumberVerifier());
    }

    public void addComponentsToFrame() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // add in the first row of controls
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(2, 2, 2, 2);
        c.gridx = 0;
        c.gridy = 0;
        this.add(new JLabel("Unit Price"), c);
        c.gridx = 1;
        this.add(unitPriceTextField, c);
        c.gridx = 3;
        this.add(new JLabel("Multiplier"), c);
        c.gridx = 4;
        this.add(multiplierFormulaTextField, c);
        c.gridx = 5;
        this.add(multiplierFormulaCopyButton, c);

        // add in the second row of controls
        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("Basis Value"), c);
        c.gridx = 1;
        this.add(basisValueTextField, c);
        c.gridx = 3;
        this.add(new JLabel("Discount"), c);
        c.gridx = 4;
        this.add(discountFormulaTextField, c);
        c.gridx = 5;
        this.add(discountFormulaCopyButton, c);

        // add in the third row of controls
        c.gridx = 0;
        c.gridy = 2;
        this.add(new JLabel("Decimals"), c);
        c.gridx = 1;
        this.add(decimalsComboBox, c);
        c.gridx = 3;
        this.add(new JLabel("Markup"), c);
        c.gridx = 4;
        this.add(markupFormulaTextField, c);
        c.gridx = 5;
        this.add(markupFormulaCopyButton, c);

        // add in the fourth row of controls
        c.gridx = 3;
        c.gridy = 3;
        this.add(new JLabel("Gross Profit"), c);
        c.gridx = 4;
        this.add(grossProfitFormulaTextField, c);
        c.gridx = 5;
        this.add(grossProfitFormulaCopyButton, c);

        // add the separator
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 4;
        c.fill = GridBagConstraints.VERTICAL;
        this.add(new JSeparator(SwingConstants.VERTICAL), c);

        this.setBorder(new EmptyBorder(10, 10, 10, 10));

    }

}
