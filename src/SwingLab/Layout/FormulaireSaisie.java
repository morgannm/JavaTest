package SwingLab.Layout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by morga on 01/10/2017.
 */
public class FormulaireSaisie extends JFrame {
    // Formulaire de saisie avec des contrôles alignés dont la hauteur ne varie pas avec la taille de la fenêtre
    public FormulaireSaisie() {
        super("Formulaire de saisie");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new BorderLayout()); // par défaut

        // Partie supérieure avec les contrôles de saisie
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(4,2,5,5));
        northPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        northPanel.add(new JLabel("Blancs : "));
        JTextField blancsTextField = new JTextField();
        blancsTextField.setSize(20,10);
        northPanel.add(blancsTextField);
        northPanel.add(new JLabel("Noirs : "));
        northPanel.add(new JTextField());
        northPanel.add(new JLabel("Date : "));
        northPanel.add(new JTextField());
        northPanel.add(new JLabel("Résultat : "));
        northPanel.add(new JTextField());

        // Boutons de commande en bas
        JPanel bottomPanel = new JPanel();
        JButton okButton = new JButton("Ok");
        JButton annulerButton = new JButton("Annuler");
        bottomPanel.add(okButton);
        bottomPanel.add(annulerButton);

        // Ajout des Panel à la fenêtre
        add(northPanel, BorderLayout.NORTH); // NB : si on ajoute le Panel dans CENTER, la hauteur des contrôles de saisie est ajustée pour occuper tout l'espace disponible
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);

    }

    public static void main(String[] arguments) {
        FormulaireSaisie lt = new FormulaireSaisie();
    }

}
