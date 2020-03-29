package SwingLab.JOptionPane;

import javax.swing.*;

public class BoitesConfirmation {
    public static void main(String[] args) {
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null,
                "Est-ce que vous confimez?",
                "Confirmation",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        switch(option) {
            case JOptionPane.YES_OPTION:
                new JOptionPane().showMessageDialog(null,"Oui");
                break;
            case JOptionPane.NO_OPTION:
                new JOptionPane().showMessageDialog(null,"Non");
                break;
            case JOptionPane.CANCEL_OPTION:
                new JOptionPane().showMessageDialog(null,"Annuler");
                break;
        }

    }
}
