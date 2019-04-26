package SwingLab.Graphics.RondCentre;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
    public Fenetre(String title, int width, int height){
        this.setTitle(title);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Panneau());

        this.setVisible(true);
    }
}
