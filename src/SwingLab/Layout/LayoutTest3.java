package SwingLab.Layout;

import java.awt.*;
import javax.swing.*;

// TestThread1 de différents Layouts
public class LayoutTest3 extends JFrame {
    JPanel centerPanel;
    JPanel bottomPanel;
    JButton okButton;
    JButton cancelButton;
    JTextArea testTextArea;
    JButton centerButton;

    public LayoutTest3() {
        super("LayoutTest3 : CenterPanel + BottomPanel");
        setLookAndFeel();
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        BorderLayout blo = new BorderLayout();
        setLayout(blo);

        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        // Partie centrale
        //centerPanel.setLayout(new BorderLayout()); // définit le centerPanel comme un BorderLayout pour que ce qu'il y a au centre occupe tout l'espace disponible
        centerButton = new JButton("Center");
        testTextArea = new JTextArea(40,40);
        centerPanel.add(testTextArea,BorderLayout.CENTER); // le TextArea va occuper tout l'espace disponible
        centerPanel.add(centerButton,BorderLayout.SOUTH);

        // Partie inférieure
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");
        bottomPanel.add(okButton);
        bottomPanel.add(cancelButton);
        FlowLayout flo = new FlowLayout(FlowLayout.RIGHT);
        bottomPanel.setLayout(flo);

        add(bottomPanel,BorderLayout.SOUTH);
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
        LayoutTest3 lt = new LayoutTest3();
    }
}
