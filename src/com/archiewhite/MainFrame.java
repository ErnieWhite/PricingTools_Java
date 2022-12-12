package com.archiewhite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fileMenu, viewMenu;
    JMenuItem findBasisMenuItem, findFormulaMenuItem, formulaConverterMenuItem, exitMenuItem;

    Container cardPane;
    CardLayout cardLayout;
    FindFormulasFrame cardFindFormulas;
    FindBasisFrame cardFindBasisValue;
    FormulaConverterFrame cardFormulaConverter;
    
    final static String FINDFORMULAS = "Find Formulas";
    final static String FORMULACONVERTER = "Convert Formulas";
    final static String FINDBASISVALUE = "Find Basis Value";

    MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(this);

        viewMenu = new JMenu("View");
        findBasisMenuItem = new JMenuItem("Find Basis Value");
        findFormulaMenuItem = new JMenuItem("Find Formula");
        formulaConverterMenuItem = new JMenuItem("Formula Converter");

        findBasisMenuItem.addActionListener(this);
        findFormulaMenuItem.addActionListener(this);
        formulaConverterMenuItem.addActionListener(this);

        viewMenu.add(findBasisMenuItem);
        viewMenu.add(findFormulaMenuItem);
        viewMenu.add(formulaConverterMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);

        this.setJMenuBar(menuBar);

        cardLayout = new CardLayout();

        cardPane = this.getContentPane();
        cardPane.setLayout(cardLayout);

        cardFindFormulas = new FindFormulasFrame();
        cardFindBasisValue = new FindBasisFrame();
        cardFormulaConverter = new FormulaConverterFrame();

        cardPane.add(FINDFORMULAS, cardFindFormulas);
        cardPane.add(FINDBASISVALUE, cardFindBasisValue);
        cardPane.add(FORMULACONVERTER, cardFormulaConverter);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == findBasisMenuItem) {
            cardLayout.show(cardPane, FINDBASISVALUE);
        }
        if (e.getSource() == findFormulaMenuItem) {
            cardLayout.show(cardPane, FINDFORMULAS);
        }
        if (e.getSource() == formulaConverterMenuItem) {
            cardLayout.show(cardPane, FORMULACONVERTER);
        }
        if (e.getSource() == exitMenuItem) {
            System.exit(0);
        }
        //TODO: Fix this.  It sizes the window to the width of the widest card and height to the tallest card
        //                 not just the current card.
        this.pack();
    }
}
