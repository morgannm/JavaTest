package SwingLab.JTabbedPane;

import javax.swing.*;
import java.awt.*;

public class JTabbedPaneDemo extends JFrame {
    private JTabbedPane onglet;

    public JTabbedPaneDemo() {
        this.setLocationRelativeTo(null);
        this.setTitle("Démo JTabbedPane : onglets");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(600, 250);

        onglet = new JTabbedPane();

        // Onglet 1 : contrôles de saisie dans un tableau
        JPanel pan1 = new JPanel(); // Panel container de l'onglet
        pan1.setLayout(new BorderLayout()); // nécessaire pour organiser le contenu et que le tableau occupe toute la largeur

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(3,2,5,5));
        northPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        northPanel.add(new JLabel("Nom : "));
        JTextField nomTextField = new JTextField();
        nomTextField.setSize(20,10);
        northPanel.add(nomTextField);

        northPanel.add(new JLabel("Code : "));
        JTextField codeTextField = new JTextField();
        codeTextField.setSize(20,10);
        northPanel.add(codeTextField);

        northPanel.add(new JLabel("Date dernière maj : "));
        JLabel lastUpdateDate = new JLabel("01/01/2020");
        northPanel.add(lastUpdateDate);

        pan1.add(northPanel, BorderLayout.NORTH);
        onglet.add("Onglet 1",pan1);

        JPanel pan2 = new JPanel();
        JLabel label2 = new JLabel("Onglet 2");
        pan2.add(label2);
        onglet.add("Onglet 2",pan2);

        JPanel pan3 = new JPanel();
        JButton button3 = new JButton("Onglet3");
        pan3.add(button3);
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(100,20));
        pan3.add(textField);
        onglet.add("Onglet 3",pan3);

        add(onglet, BorderLayout.CENTER);

        // Boutons en bas de la fenêtre visibles quel que soit l'onglet actif
        JPanel southPanel = new JPanel();

        // Caler les boutons sur la droite
        FlowLayout flo = new FlowLayout();
        flo.setAlignment(FlowLayout.RIGHT);
        southPanel.setLayout(flo);

        southPanel.add(new JButton("Valider"));
        southPanel.add(new JButton("Annuler"));
        add(southPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        JTabbedPaneDemo demo = new JTabbedPaneDemo();
    }

}
