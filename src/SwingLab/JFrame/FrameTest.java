package SwingLab.JFrame;

import javax.swing.*;
import java.awt.*;

public class FrameTest extends JFrame {
    public FrameTest() {
        super("Saluton mondo!");
        setLookAndFeel();
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // FlowLayout permet de disposer automatiquement les contrôles du Frame
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        JButton okButton = new JButton("OK");
        add(okButton);
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
        FrameTest frm = new FrameTest();
    }
}
