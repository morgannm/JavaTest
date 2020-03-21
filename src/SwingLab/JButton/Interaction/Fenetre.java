package SwingLab.JButton.Interaction;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {
    Bouton bouton1;
    JButton bouton2;
    JLabel label;
    int nbClicsBouton1;
    int nbClicsBouton2;
    JButton go;
    JButton stop;
    JLabel compteurLabel;
    int compteur;
    boolean running;
    private Thread t;

    public Fenetre() {
        this.setTitle("Interaction");
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Label et boutons de contrôles
        nbClicsBouton1=0;
        nbClicsBouton2=0;
        JPanel north = new JPanel();
        // Label au centre de la fenêtre
        label = new JLabel("Aucun clic");
        label.setHorizontalAlignment(JLabel.CENTER);
        // Boutons
        bouton1 = new Bouton("Bouton 1");
        //bouton1.addActionListener(this);
        bouton1.addActionListener(new Bouton1Listener());
        bouton1.addActionListener(new Bouton1AutreListener()); // 2 ActionListener différents pour le même bouton
        north.add(bouton1);
        bouton2 = new JButton("Bouton 2");
        //bouton2.addActionListener(this);
        bouton2.addActionListener(new Bouton2Listener());
        north.add(bouton2);
        //add(label, BorderLayout.NORTH);
        north.add(label);
        add(north, BorderLayout.NORTH);

        // Centre de la fenêtre : compteur et boutons Go et Stop
        JPanel center = new JPanel();
        go = new JButton("Go");
        go.addActionListener(new GoActionListener());
        stop = new JButton("Stop");
        stop.addActionListener(new StopActionListener());
        compteurLabel = new JLabel();
        center.add(go);
        center.add(stop);
        stop.setEnabled(false);
        center.add(compteurLabel);
        add(center, BorderLayout.CENTER);
        running=false;

        this.setVisible(true);
    }

    class GoActionListener implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            running=true;
            t = new Thread(new PlayAnimation());
            t.start();
            go.setEnabled(false);
            stop.setEnabled(true);
            //Go();
        }
    }

    public void Go() {
        while (this.running) {
            compteur++;
            this.compteurLabel.setText(String.format("%d",compteur));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class StopActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            running=false;
            go.setEnabled(true);
            stop.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
    }

    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bouton1)
            nbClicsBouton1++;
        else if (e.getSource() == bouton2)
            nbClicsBouton2++;
        label.setText("Bouton 1 : " + nbClicsBouton1 + " clic(s) / Bouton 2 : " + nbClicsBouton2 + " clic(s)");
    }
     */

    class Bouton1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            nbClicsBouton1++;
            UpdateLabel();
        }
    }

    class Bouton1AutreListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            nbClicsBouton1++;
            //UpdateLabel();
        }
    }

    class Bouton2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            nbClicsBouton2++;
            UpdateLabel();
        }
    }

    public void UpdateLabel() {
        label.setText("Bouton 1 : " + nbClicsBouton1 + " clic(s) / Bouton 2 : " + nbClicsBouton2 + " clic(s)");
    }

    class PlayAnimation implements Runnable {

        @Override
        public void run() {
            Go();
        }
    }
}
