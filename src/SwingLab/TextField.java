package SwingLab;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextField extends JFrame {
    public TextField() {
        super("TextField");
        setLookAndFeel();
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel pageLabel = new JLabel("Web page address: ", JLabel.RIGHT);
        panel1.add(pageLabel);
        JTextField pageAddress = new JTextField("Valeur par défaut");
        pageAddress.setPreferredSize(new Dimension(400,30));
        pageAddress.setForeground(Color.BLUE);
        pageAddress.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("focusGained");
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("focusLost");
            }
        });
        Font police = new Font("Arial", Font.BOLD, 14);
        pageAddress.setFont(police);
        panel1.add(pageAddress);
        mainPanel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel2.add(new JLabel("Test"));
        JTextField textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(400,30));
        panel2.add(textField2);
        mainPanel.add(panel2);

        add(mainPanel);
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
