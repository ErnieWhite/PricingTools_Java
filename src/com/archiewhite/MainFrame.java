package com.archiewhite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fileMenu, viewMenu;
    JMenuItem findBasisMenuItem, findFormulaMenuItem, formulaConverterMenuItem, exitMenuItem;

    Container contentPane;
    FindFormulasFrame cardFindFormulas;
    FindBasisFrame cardFindBasisValue;
    FormulaConverterFrame cardFormulaConverter;
    JPanel currentFrame;
    
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
        findBasisMenuItem = new JMenuItem(FINDBASISVALUE);
        findFormulaMenuItem = new JMenuItem(FINDFORMULAS);
        formulaConverterMenuItem = new JMenuItem(FORMULACONVERTER);

        findBasisMenuItem.addActionListener(this);
        findFormulaMenuItem.addActionListener(this);
        formulaConverterMenuItem.addActionListener(this);

        viewMenu.add(findBasisMenuItem);
        viewMenu.add(findFormulaMenuItem);
        viewMenu.add(formulaConverterMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);

        this.setJMenuBar(menuBar);


        contentPane = this.getContentPane();

        cardFindFormulas = new FindFormulasFrame();
        cardFindBasisValue = new FindBasisFrame();
        cardFormulaConverter = new FormulaConverterFrame();

        this.add(cardFormulaConverter);
        currentFrame = cardFormulaConverter;
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == findBasisMenuItem) {
            swapInPanel(cardFindBasisValue);
        }
        if (e.getSource() == findFormulaMenuItem) {
            swapInPanel(cardFindFormulas);
        }
        if (e.getSource() == formulaConverterMenuItem) {
            swapInPanel(cardFormulaConverter);
        }
        if (e.getSource() == exitMenuItem) {
            System.exit(0);
        }
        //TODO: Fix this.  It sizes the window to the width of the widest card and height to the tallest card
        //                 not just the current card.
        this.pack();
    }
    public void swapInPanel(JPanel frame) {
        this.remove(currentFrame);
        this.add(frame);
        this.currentFrame = frame;
        this.pack();
    }
}
