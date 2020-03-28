package SwingLab;
import javax.swing.*;
import java.awt.*;

public class TextField extends JFrame {
    public TextField() {
        super("TextField");
        setLookAndFeel();
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel pageLabel = new JLabel("Web page address: ", JLabel.RIGHT);

        JTextField pageAddress = new JTextField("Valeur par défaut");
        pageAddress.setPreferredSize(new Dimension(400,30));
        pageAddress.setForeground(Color.BLUE);
        Font police = new Font("Arial", Font.BOLD, 14);
        pageAddress.setFont(police);

        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        add(pageLabel);
        add(pageAddress);
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
        TextField tf = new TextField();
    }
}
