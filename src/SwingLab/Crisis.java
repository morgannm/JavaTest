package SwingLab;

import java.awt.*;
import javax.swing.*;

// Test de FlowLayout et GridLayout
public class Crisis extends JFrame {
    JButton panicButton;
    JButton dontPanicButton;
    JButton blameButton;
    JButton mediaButton;
    JButton saveButton;

    public Crisis() {
        super("Crisis");
        setLookAndFeel();
        // L'arrangement des contrôles dépend de la taille du container
        setSize(348, 128); // contrôles sur 2 lignes
        //setSize(200, 200); // contrôles sur 4 lignes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        
        // GridLayout 2 lignes, 3 colonnes
        // GridLayout grid = new GridLayout(2, 3);
        // setLayout(grid);
        
        panicButton = new JButton("Panic");
        dontPanicButton = new JButton("Don't Panic");
        blameButton = new JButton("Blame Others");
        mediaButton = new JButton("Notify the Media");
        saveButton = new JButton("Save Yourself");
        add(panicButton);
        add(dontPanicButton);
        add(blameButton);
        add(mediaButton);
        add(saveButton);
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
        Crisis cr = new Crisis();
    }
}
