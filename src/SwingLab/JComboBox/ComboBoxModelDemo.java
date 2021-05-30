package SwingLab.JComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

/*
    JComboBox liée à un objet DefaultComboBoxModel, lui-même lié à un objet Planete
 */
public class ComboBoxModelDemo extends JFrame {
    private JComboBox planetesJComboBox;
    private JLabel selection;

    public ComboBoxModelDemo() {
        setTitle("Démo JComboBox avec DefaultComboBoxModel");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel north = new JPanel();
        JLabel label = new JLabel("Planète : ");

        final DefaultComboBoxModel<Planete> model = new DefaultComboBoxModel<>();
        List<Planete> planetes = getPlanetes();
        for (Planete planete : planetes) {
            model.addElement(planete);
        }
        planetesJComboBox = new JComboBox<>(model);
        planetesJComboBox.setPreferredSize(new Dimension(150,20));
        planetesJComboBox.addItemListener(new ItemState());
        planetesJComboBox.addActionListener(new ItemAction());
        north.add(label);
        north.add(planetesJComboBox);
        JLabel label2 = new JLabel("Planète sélectionnée : ");
        north.add(label2);
        selection = new JLabel();
        north.add(selection);
        add(north, BorderLayout.NORTH);

        planetesJComboBox.setSelectedIndex(2);

        setVisible(true);
    }

    private ArrayList<Planete> getPlanetes() {
        ArrayList<Planete> list = new ArrayList<>();
        list.add(new Planete("Mercure"));
        list.add(new Planete("Venus"));
        list.add(new Planete("Terre"));
        list.add(new Planete("Mars"));
        list.add(new Planete("Jupiter"));
        return list;
    }


    public static void main(String[] args) {
        ComboBoxModelDemo comboxDemo = new ComboBoxModelDemo();
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
            System.out.println("Elément sélectionné : " + planetesJComboBox.getSelectedItem());
            selection.setText(planetesJComboBox.getSelectedItem().toString());
        }
    }

    public class Planete {
        private String nom;
        public Planete(String nom) {
            this.nom = nom;
        }
        public String getNom() {return this.nom;}
        public String toString() {return this.nom;}
    }
}
