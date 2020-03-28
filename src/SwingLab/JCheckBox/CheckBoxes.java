package SwingLab.JCheckBox;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxes extends JFrame {
    private JLabel selection;
    JCheckBox jumboSize;
    JRadioButton jambon;
    JRadioButton boeuf;
    JRadioButton vegetarien;

    public CheckBoxes() {
        super("CheckBoxes");
        setLookAndFeel();
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        jumboSize = new JCheckBox("Jumbo Size", true);
        jumboSize.addActionListener(new StateListener());
        jambon = new JRadioButton("Jambon", true);
        jambon.addActionListener(new StateListener());
        boeuf = new JRadioButton("Boeuf", false);
        boeuf.addActionListener(new StateListener());
        vegetarien = new JRadioButton("Végétarien", false);
        vegetarien.addActionListener(new StateListener());
        ButtonGroup meals = new ButtonGroup();
        meals.add(jambon);
        meals.add(boeuf);
        meals.add(vegetarien);

        // Partie supérieure avec les contrôles de saisie
        JPanel northPanel = new JPanel();
        // On divise le panel en 2 lignes
        northPanel.setLayout(new GridLayout(2,1,5,5));
        northPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        northPanel.add(jumboSize);  // 1ère ligne du northPanel

        // 2ème ligne du northpanel
        JPanel ligne2 = new JPanel();
        ligne2.setLayout(new FlowLayout(FlowLayout.LEFT));
        ligne2.add(jambon);
        ligne2.add(boeuf);
        ligne2.add(vegetarien);
        northPanel.add(ligne2);

        add(northPanel, BorderLayout.NORTH);

        JPanel center = new JPanel();
        JLabel label = new JLabel("Sélection : ");
        center.add(label);
        selection = new JLabel();
        center.add(selection);
        add(center,BorderLayout.CENTER);

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

    class StateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String state;
            if (jumboSize.isSelected())
                selection.setText("Jumbo size");
            else
                selection.setText("Normal size");
        }
    }

    public static void main(String[] arguments) {
        CheckBoxes cb = new CheckBoxes();
    }
}
