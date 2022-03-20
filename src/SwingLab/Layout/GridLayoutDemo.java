package SwingLab.Layout;

import javax.swing.*;
import java.awt.*;


/**
 * Created by morgannm on 10/09/2016.
 */
public class GridLayoutDemo extends JFrame {

    public GridLayoutDemo() {
        super("GridLayoutDemo");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Partie supérieure de la fenêtre
        JPanel northPanel = new JPanel();
        //northPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); // pour définir une marge
        JPanel northPanel1 = new JPanel();
        northPanel1.setBorder(BorderFactory.createLineBorder(Color.black)); // bordure
        JLabel titre = new JLabel("Partie supérieure de la fenêtre : JPanel (NORTH) bordure black");
        northPanel1.add(titre);
        northPanel.add(northPanel1);
        add(northPanel, BorderLayout.NORTH);

        // Partie centrale de la fenêtre
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(15,15,15,15),
                        BorderFactory.createLineBorder(Color.BLUE))); // espace à l'extérieur de la bordure
        centerPanel.setLayout(new GridLayout(2,1,0,10)); // tableau 2 lignes, 1 colonnes, espace horizontal entre les contrôles, espace vertical
        // Les cellules ont exactement la même taille

        JPanel ligne1 = new JPanel();
        ligne1.setBorder(BorderFactory.createTitledBorder("Ligne 1 : JPanel -> GridLayout 1 ligne, 3 colonnes"));
        ligne1.setLayout(new GridLayout(1,3,10,0));
        JLabel label1 = new JLabel("Ligne 1 Colonne 1 : JLabel border red");
        label1.setBorder(BorderFactory.createLineBorder(Color.red));
        ligne1.add(label1);
        JLabel label2 = new JLabel("Ligne 2 Colonne 1 : JLabel border green");
        label2.setBorder(BorderFactory.createLineBorder(Color.green));
        ligne1.add(label2);
        ligne1.add(new JLabel("Ligne 1 Colonne 3 JLabel"));
        centerPanel.add(ligne1);

        JPanel ligne2 = new JPanel();
        ligne2.setBorder(BorderFactory.createTitledBorder("Ligne 2 : JPanel -> GridLayout 1 ligne, 2 colonnes"));
        ligne2.setLayout(new GridLayout(1,2,10,0));
        ligne2.add(new JLabel("Ligne 2 Colonne 1 : JLabel"));
        ligne2.add(new JLabel("Ligne 2 Colonne 2 : JLabel"));
        centerPanel.add(ligne2);

        add(centerPanel, BorderLayout.CENTER);

        // Partie inférieure de la fenêtre
        JPanel southPanel = new JPanel();
        JLabel pied = new JLabel("Partie inférieure de la fenêtre : JPanel (SOUTH)");
        southPanel.add(pied);
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] arguments) {
        GridLayoutDemo gridLayoutDemo = new GridLayoutDemo();
    }

}
