package com.archiewhite;

import javax.swing.*;
import java.awt.*;

public class FindBasisFrame extends JPanel {
    JLabel unitPriceLabel;
    JLabel formulaLabel;
    JLabel decimalsLabel;
    JLabel basisValueLabel;

    JTextField unitPriceTextField;
    JTextField formulaTextField;
    JTextField basisValueTextField;

    JComboBox<String> decimalsCombobox;

    JButton copyButton;

    FindBasisFrame() {

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

        c.gridx = 0;
        c.gridy = 0;
        this.add(unitPriceLabel, c);
        c.gridx = 1;
        this.add(unitPriceTextField, c);

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

        c.gridx = 0;
        c.gridy = 3;
        this.add(basisValueLabel, c);
        c.gridx = 1;
        this.add(basisValueTextField, c);

        c.gridy = 4;
        this.add(copyButton, c);

    }
}
