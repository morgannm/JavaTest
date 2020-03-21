package SwingLab.JFrame;

import javax.swing.JFrame;

public class FrameTest2 extends JFrame {
    public FrameTest2() {
        //Définit un titre pour notre fenêtre
        this.setTitle("Ma première fenêtre Java");
        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        this.setSize(400, 300);

        // Positionnement de la fenêtre sur l'écran
        //this.setLocationRelativeTo(null); // positionnement au centre
        this.setLocation(100,200); // positionnement par rapport au bord supérieur gauche de l'écran

        //Termine le processus lorsqu'on clique sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible
        this.setVisible(true);
    }

    public static void main(String[] args){
        FrameTest2 fenetre = new FrameTest2();
    }
}