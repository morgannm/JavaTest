package SwingLab.Layout;

import java.awt.*;
import javax.swing.*;

// Test de BorderLayout 
public class BorderLayoutTest extends JFrame {
    JButton northButton;
    JButton southButton;
    JButton eastButton;
    JButton westButton;
    JButton centerButton;

    public BorderLayoutTest() {
        super("BorderLayoutTest");
        setLookAndFeel();
        // L'arrangement des contrôles dépend de la taille du container
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout blo = new BorderLayout();
        setLayout(blo);
        
        // GridLayout 2 lignes, 3 colonnes
        // GridLayout grid = new GridLayout(2, 3);
        // setLayout(grid);
        
        northButton = new JButton("BorderLayout.NORTH");
        southButton = new JButton("BorderLayout.SOUTH");
        eastButton = new JButton("BorderLayout.EAST");
        westButton = new JButton("BorderLayout.WEST");
        centerButton = new JButton("BorderLayout.CENTER");
        add(northButton,BorderLayout.NORTH);
        add(southButton,BorderLayout.SOUTH);
        add(eastButton,BorderLayout.EAST);
        add(westButton,BorderLayout.WEST);
        add(centerButton,BorderLayout.CENTER);
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

    public static void main(String[] arguments) {
        BorderLayoutTest cr = new BorderLayoutTest();
    }
}
