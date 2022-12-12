package com.archiewhite;

import javax.swing.*;
import java.awt.*;

public class FormulaConverterFrame extends JPanel {
    JLabel formulaLabel;
    JLabel decimalsLabel;
    JLabel multiplierLabel;
    JLabel discountLabel;
    JLabel markupLabel;
    JLabel grossProfitLabel;

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

    FormulaConverterFrame() {

        formulaLabel = new JLabel("Formula");
        multiplierLabel = new JLabel("Multiplier");
        discountLabel = new JLabel("Discount");
        markupLabel = new JLabel("Markup");
        grossProfitLabel = new JLabel("Gross Profit");
        decimalsLabel = new JLabel("Decimals");

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
        c.gridx = 0;
        c.gridy = 0;
        this.add(formulaLabel, c);
        c.gridx = 1;
        this.add(formulaTextField, c);

        // add the decimals row
        c.gridx = 0;
        c.gridy = 1;
        this.add(decimalsLabel, c);
        c.gridx = 1;
        this.add(decimalsComboBox, c);

        // add the separator
        c.gridx = 0;
        c.gridy = 2;
        this.add(new JSeparator(), c);

        // add the multiplier row
        c.gridx = 0;
        c.gridy = 3;
        this.add(multiplierLabel, c);
        c.gridx = 1;
        this.add(multiplierTextField, c);
        c.gridx = 2;
        this.add(multiplierCopyButton, c);

        // add discount row
        c.gridx = 0;
        c.gridy = 4;
        this.add(discountLabel, c);
        c.gridx = 1;
        this.add(discountTextField, c);
        c.gridx = 2;
        this.add(discountCopyButton, c);

        // add the markup row
        c.gridx = 0;
        c.gridy = 5;
        this.add(markupLabel, c);
        c.gridx = 1;
        this.add(markupTextField, c);
        c.gridx = 2;
        this.add(markupCopyButton, c);

        // add the gross profit row
        c.gridx = 0;
        c.gridy = 6;
        this.add(grossProfitLabel, c);
        c.gridx = 1;
        this.add(grossProfitTextField, c);
        c.gridx = 2;
        this.add(grossProfitCopyButton, c);
    }
}
