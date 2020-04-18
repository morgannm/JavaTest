package SwingLab.JSplitPane;

import javax.swing.*;
import java.awt.*;

public class JSplitPaneDemo extends JFrame {
    //On déclare notre objet JSplitPane
    private JSplitPane split;

    public JSplitPaneDemo(){
        this.setLocationRelativeTo(null);
        this.setTitle("Gérer vos conteneur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);

        //On crée deux conteneurs de couleurs différentes
        JPanel pan = new JPanel();
        pan.setBackground(Color.blue);

        JPanel pan2 = new JPanel();
        pan2.setBackground(Color.red);

        //On construit enfin notre séparateur
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan, pan2);

        // Boutons flèches permettant de faire complètement disparaître un des côtés de la séparation
        split.setOneTouchExpandable(true);

        // Définir la largeur de la barre de séparation
        split.setDividerSize(20);

        // Emplacement de la barre de séparation
        split.setDividerLocation(200);

        //On le passe ensuite au content pane de notre objet Fenetre
        //placé au centre pour qu'il utilise tout l'espace disponible
        this.getContentPane().add(split, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args){
        JSplitPaneDemo fen = new JSplitPaneDemo();
    }
}

