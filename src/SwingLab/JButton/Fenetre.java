package SwingLab.JButton;

import javax.swing.*;

/**
 * Created by morga on 23/09/2017.
 */
public class Fenetre extends JFrame {

    private JPanel pan = new JPanel();
    private JButton bouton = new JButton("Mon bouton");

    public Fenetre() {
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // Ajout du bouton
        pan.add(bouton);
        this.setContentPane(pan);
        this.setVisible(true);

    }
}
