package SwingLab.Layout;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutDemo2 extends JFrame {

    // Affiche un tableau de matchs
    public GridBagLayoutDemo2() {
        super("GridBagLayoutDemo2");
        setSize(1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Partie centrale de la fenêtre
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1,3,0,10)); // tableau 1 lignes, 3 colonnes, espace horizontal entre les contrôles, espace vertical
        // Les cellules ont exactement la même taille

        // 1ère colonne : 4 matchs
        JPanel colonne1 = new JPanel();
        colonne1.setLayout(new GridLayout(4,1,10,0));
        for (int line=1; line<=4; line++) {
            PlayoffGamePanel playoffGamePanel = new PlayoffGamePanel(1);
            colonne1.add(playoffGamePanel);
        }
        centerPanel.add(colonne1);

        // 2ère colonne : 2 matchs
        JPanel colonne2 = new JPanel();
        colonne2.setLayout(new GridLayout(2,1,10,0));
        for (int line=1; line<=2; line++) {
            PlayoffGamePanel playoffGamePanel = new PlayoffGamePanel(2);
            colonne2.add(playoffGamePanel);
        }
        centerPanel.add(colonne2);

        // 3ème colonne : 1 match
        PlayoffGamePanel playoffGamePanel = new PlayoffGamePanel(3);
        centerPanel.add(playoffGamePanel);

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] arguments) {
        GridBagLayoutDemo2 gridLayoutDemo2 = new GridBagLayoutDemo2();
    }

    public class PlayoffGamePanel extends JPanel {
        public PlayoffGamePanel(int round) {
            setLayout(new GridBagLayout()); // pour centrer verticalement
            setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createEmptyBorder(10,10,10,10),
                            BorderFactory.createLineBorder(Color.blue))); // espace à l'extérieur de la bordure

            JPanel matchsPanel = new JPanel();
            matchsPanel.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createEmptyBorder(10,10,10,10),
                            BorderFactory.createLineBorder(Color.black))); // espace à l'extérieur de la bordure
            matchsPanel.setLayout(new BoxLayout(matchsPanel, BoxLayout.PAGE_AXIS));

            JPanel match1 = new JPanel();
            match1.setLayout(new BoxLayout(match1, BoxLayout.LINE_AXIS));
            match1.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createEmptyBorder(10,10,10,10),
                            BorderFactory.createLineBorder(Color.red))); // espace à l'extérieur de la bordure
            match1.add(new JLabel("Round " + round));
            match1.add(new JLabel("  Equipe 1"));
            match1.add(new JLabel("  Score 1"));
            matchsPanel.add(match1);

            JPanel match2 = new JPanel();
            match2.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createEmptyBorder(10,10,10,10),
                            BorderFactory.createLineBorder(Color.red))); // espace à l'extérieur de la bordure
            match2.setLayout(new BoxLayout(match2, BoxLayout.LINE_AXIS));
            match2.add(new JLabel("Round "+ round));
            match2.add(new JLabel("  Equipe 2"));
            match2.add(new JLabel("  Score 2"));
            matchsPanel.add(match2);

            add(matchsPanel,new GridBagConstraints());

        }
    }

}
