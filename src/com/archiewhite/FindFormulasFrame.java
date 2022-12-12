package com.archiewhite;

import javax.swing.*;

import java.awt.*;

public class FindFormulasFrame extends JFrame {
    JLabel unitPriceLabel;
    JLabel basisValueLabel;
    JLabel decimalsLabel;

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


    FindFormulasFrame() {
        this.setTitle("Find Formulas");
        this.unitPriceLabel = new JLabel("Unit Price");
        this.basisValueLabel = new JLabel("Basis Value");
        this.decimalsLabel = new JLabel("Decimals");

        this.unitPriceTextField = new JTextField();
        this.basisValueTextField = new JTextField();
        String[] comboBoxItems = {"Auto", "0", "1", "2", "3", "4", "5", "6"};
        this.decimalsComboBox = new JComboBox<>(comboBoxItems);

        multiplierFormulaTextField = new JTextField(8);
        discountFormulaTextField = new JTextField(8);
        markupFormulaTextField = new JTextField(8);
        grossProfitFormulaTextField = new JTextField(8);

        multiplierFormulaCopyButton = new JButton("Copy");
        discountFormulaCopyButton = new JButton("Copy");
        markupFormulaCopyButton = new JButton("Copy");
        grossProfitFormulaCopyButton = new JButton("Copy");

        addComponentsToFrame();
        setUpFieldValidators();
        this.pack();

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
        c.gridx = 0;
        c.gridy = 0;
        this.add(unitPriceLabel, c);
        c.gridx = 1;
        this.add(unitPriceTextField, c);
        c.gridx = 2;
        this.add(multiplierFormulaTextField, c);
        c.gridx = 3;
        this.add(multiplierFormulaCopyButton, c);

        // add in the second row of controls
        c.gridx = 0;
        c.gridy = 1;
        this.add(basisValueLabel, c);
        c.gridx = 1;
        this.add(basisValueTextField, c);
        c.gridx = 2;
        this.add(discountFormulaTextField, c);
        c.gridx = 3;
        this.add(discountFormulaCopyButton, c);

        // add in the third row of controls
        c.gridx = 0;
        c.gridy = 2;
        this.add(decimalsLabel, c);
        c.gridx = 1;
        this.add(decimalsComboBox, c);
        c.gridx = 2;
        this.add(markupFormulaTextField, c);
        c.gridx = 3;
        this.add(markupFormulaCopyButton, c);

        // add in the fourth row of controls
        c.gridx = 2;
        c.gridy = 3;
        this.add(grossProfitFormulaTextField, c);
        c.gridx = 3;
        this.add(grossProfitFormulaCopyButton, c);

    }

}
