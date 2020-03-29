package SwingLab.JOptionPane;

import javax.swing.*;

public class BoiteSaisieListeDeroulante {
    public static void main(String[] args) {
        String[] choix = {"Loiret", "Eure-et-Loir", "Indre", "Cher", "Indre-et-Loire", "Loir-et-Cher"};
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        String departement = (String)jop.showInputDialog(null,
                "Sélectionnez un département",
                "Choix département",
                JOptionPane.QUESTION_MESSAGE,
                null,
                choix,
                choix[0]);
        jop2.showMessageDialog(null, "Le département sélectionné est " + departement, "Département", JOptionPane.INFORMATION_MESSAGE);

    }
}

