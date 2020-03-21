package SwingLab.Layout;

import javax.swing.*;
import java.awt.*;

public class GridLayoutDemoOpenClassRooms extends JFrame {
    public GridLayoutDemoOpenClassRooms() {
        this.setTitle("Bouton");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //On définit le layout à utiliser sur le content pane
        //Trois lignes sur deux colonnes
        this.setLayout(new GridLayout(3, 2));
        //On ajoute le bouton au content pane de la JFrame
        this.getContentPane().add(new JButton("1"));
        this.getContentPane().add(new JButton("2"));
        this.getContentPane().add(new JButton("3"));
        this.getContentPane().add(new JButton("4"));
        this.getContentPane().add(new JButton("5"));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        GridLayoutDemoOpenClassRooms gridLayoutDemoOpenClassRooms = new GridLayoutDemoOpenClassRooms();
    }
}
