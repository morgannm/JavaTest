package SwingLab.Layout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Box;

/**
 * Created by morga on 23/09/2017.
 * Démo de l'objet Box
 */
public class BoxDemo extends JFrame {
    public BoxDemo(){
        this.setTitle("Box Layout");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //On crée un conteneur avec gestion horizontale
        Box b1 = Box.createHorizontalBox();
        b1.add(new JButton("Bouton 1"));
        //Idem
        Box b2 = Box.createHorizontalBox();
        b2.add(new JButton("Bouton 2"));
        b2.add(new JButton("Bouton 3"));
        //Idem
        Box b3 = Box.createHorizontalBox();
        b3.add(new JButton("Bouton 4"));
        b3.add(new JButton("Bouton 5"));
        b3.add(new JButton("Bouton 6"));
        //On crée un conteneur avec gestion verticale
        Box b4 = Box.createVerticalBox();
        b4.add(b1);
        b4.add(b2);
        b4.add(b3);

        this.getContentPane().add(b4);
        this.setVisible(true);
    }

    public static void main(String[] arguments) {
        BoxDemo box = new BoxDemo();
    }

}
