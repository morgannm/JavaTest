package SwingLab.Layout;

import java.awt.*;
import javax.swing.*;

// TestThread1 de différents Layouts
public class LayoutTest extends JFrame {
    JPanel topPanel;
    JPanel leftPanel;
    JPanel rightPanel;
    JPanel centerPanel;
    JPanel bottomPanel;
    JButton okButton;
    JButton cancelButton;
    JLabel label1;
    JTextField textField1;
    JTextArea testTextArea;

    public LayoutTest() {
        super("LayoutTest");
        setLookAndFeel();
        // L'arrangement des contrôles dépend de la taille du container
        setSize(600, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout blo = new BorderLayout();
        setLayout(blo);
        
        // GridLayout 2 lignes, 3 colonnes
        // GridLayout grid = new GridLayout(2, 3);
        // setLayout(grid);
        
        leftPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();
        rightPanel = new JPanel();
        
        // Partie centrale
        testTextArea = new JTextArea(8,40);
        centerPanel.add(testTextArea);
        
        // Partie supérieure
        topPanel = new JPanel();
        FlowLayout flo1 = new FlowLayout(FlowLayout.LEFT,5,5);
        topPanel.setLayout(flo1);
        label1 = new JLabel("TestThread1 : ");
        textField1 = new JTextField(20);
        topPanel.add(label1);
        topPanel.add(textField1);

        // Partie inférieure
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");
        bottomPanel.add(okButton);
        bottomPanel.add(cancelButton);
        FlowLayout flo = new FlowLayout(FlowLayout.RIGHT);
        bottomPanel.setLayout(flo);

        add(topPanel,BorderLayout.NORTH);
        add(bottomPanel,BorderLayout.SOUTH);
        add(leftPanel,BorderLayout.EAST);
        add(rightPanel,BorderLayout.WEST);
        add(centerPanel,BorderLayout.CENTER);
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }
    
    // Définit des marges intérieures pour LayoutTest
/*    public Insets getInsets() {
        // 1ère valeur : top incluant la barre de titre de la fenêtre
        Insets squeeze = new Insets(40, 15, 20, 15);
        return squeeze;
    }
    */

    public static void main(String[] arguments) {
        LayoutTest lt = new LayoutTest();
    }
}
