package SwingLab.JOptionPane;

import javax.swing.*;

public class BoiteSaisieChoixBoutons {
    public static void main(String[] args) {
        String[] options = {"Option 1", "Option 2", "Option 3", "Option 4"};
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        int ret = jop.showOptionDialog(null,
                "Veuillez indiquer une option",
                "Options",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
        jop2.showMessageDialog(null, "Option choisie :  " + options[ret], "Option choisie", JOptionPane.INFORMATION_MESSAGE);
    }
}
