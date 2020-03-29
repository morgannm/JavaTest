package SwingLab.JOptionPane;

import javax.swing.*;

public class BoitesInformation {
    public static void main(String[] args) {
        JOptionPane jop1, jop2, jop3;

        //Boîte du message d'information
        jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "Message informatif", "Information", JOptionPane.INFORMATION_MESSAGE);

        //Boîte du message préventif
        jop2 = new JOptionPane();
        jop2.showMessageDialog(null, "Message préventif", "Attention", JOptionPane.WARNING_MESSAGE);

        //Boîte du message d'erreur
        jop3 = new JOptionPane();
        jop3.showMessageDialog(null, "Message d'erreur", "Erreur", JOptionPane.ERROR_MESSAGE);

        // Boîte de dialogue avec icône personnalisée
        ImageIcon img = new ImageIcon("resources/Danger.png");
        jop2.showMessageDialog(null, "Attention danger", "Attention", JOptionPane.WARNING_MESSAGE, img);
    }
}
