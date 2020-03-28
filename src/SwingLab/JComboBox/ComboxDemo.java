package SwingLab.JComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboxDemo extends JFrame {
    private JComboBox planetes = new JComboBox();
    private JLabel selection;

    public ComboxDemo() {
        setTitle("Démo JComboBox");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel north = new JPanel();
        JLabel label = new JLabel("Planète : ");
        planetes.addItem("Mercure");
        planetes.addItem("Venus");
        planetes.addItem("Terre");
        planetes.addItem("Mars");
        planetes.addItem("Jupiter");
        planetes.addItem("Saturne");
        planetes.addItem("Uranus");
        planetes.addItem("Neptune");
        planetes.addItem("Pluton");
        planetes.setPreferredSize(new Dimension(150,20));
        planetes.addItemListener(new ItemState());
        planetes.addActionListener(new ItemAction());
        north.add(label);
        north.add(planetes);
        JLabel label2 = new JLabel("Planète sélectionnée : ");
        north.add(label2);
        selection = new JLabel();
        north.add(selection);
        add(north, BorderLayout.NORTH);

        planetes.setSelectedIndex(2);

        setVisible(true);
    }

    public static void main(String[] args) {
        ComboxDemo comboxDemo = new ComboxDemo();
    }

    // L'événement se déclenche sur l'option précédente et ensuite sur la nouvelle option
    class ItemState implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            System.out.println("Evénement déclenché sur : " + e.getItem());
        }
    }

    class ItemAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Elément sélectionné : " + planetes.getSelectedItem());
            selection.setText((String)planetes.getSelectedItem());
        }
    }
}
