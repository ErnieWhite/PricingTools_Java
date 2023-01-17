import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fileMenu, viewMenu;
    JMenuItem findBasisMenuItem, findFormulaMenuItem, formulaConverterMenuItem, exitMenuItem;

    Container contentPane;
    FormulaFinder cardFindFormulas;
    BasisFinder cardFindBasisValue;
    FormulaConverter cardFormulaConverter;
    JPanel currentPanel;
    
    final static String FINDFORMULAS = "Find Formulas";
    final static String FORMULACONVERTER = "Convert Formulas";
    final static String FINDBASISVALUE = "Find Basis Value";

    MainWindow() {
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
        contentPane.setLayout(new BorderLayout(10, 10));

        cardFindFormulas = new FormulaFinder();
        cardFindBasisValue = new BasisFinder();
        cardFormulaConverter = new FormulaConverter();

        contentPane.add(cardFormulaConverter);
        currentPanel = cardFormulaConverter;
        this.setTitle(currentPanel.getName());
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
        this.pack();
    }
    public void swapInPanel(JPanel panel) {
        contentPane.remove(currentPanel);
        contentPane.add(panel);
        this.currentPanel = panel;
        this.setTitle(panel.getName());
        this.pack();
    }
}
