package SwingLab;

import java.awt.*;
import javax.swing.*;

// Test de BorderLayout 
public class BorderLayoutTest extends JFrame {
    JButton panicButton;
    JButton dontPanicButton;
    JButton blameButton;
    JButton mediaButton;
    JButton saveButton;

    public BorderLayoutTest() {
        super("BorderLayoutTest");
        setLookAndFeel();
        // L'arrangement des contrôles dépend de la taille du container
        setSize(400, 200); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout blo = new BorderLayout();
        setLayout(blo);
        
        // GridLayout 2 lignes, 3 colonnes
        // GridLayout grid = new GridLayout(2, 3);
        // setLayout(grid);
        
        panicButton = new JButton("Panic");
        dontPanicButton = new JButton("Don't Panic");
        blameButton = new JButton("Blame Others");
        mediaButton = new JButton("Notify the Media");
        saveButton = new JButton("Save Yourself");
        add(panicButton,BorderLayout.NORTH);
        add(dontPanicButton,BorderLayout.SOUTH);
        add(blameButton,BorderLayout.EAST);
        add(mediaButton,BorderLayout.WEST);
        add(saveButton,BorderLayout.CENTER);
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
