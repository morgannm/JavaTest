package SwingLab;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import javax.swing.*;

public class KeyListenerDemo extends JFrame {
    //private JPanel container = new JPanel();
    private JTextField jtf;
    //private JLabel lbl = new JLabel("Test des événements sur le clavier : ");
    //private JButton b = new JButton ("OK");
    private JTextField jtfInteger;

    public KeyListenerDemo(){
        this.setTitle("KeyListener Demo");
        this.setSize(800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2,5,5));
        northPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        northPanel.add(new JLabel("Affiche les événements clavier : "));
        jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(150, 30));
        //On ajoute l'écouteur à notre composant
        jtf.addKeyListener(new ClavierListener());
        northPanel.add(jtf);

        northPanel.add(new JLabel("Empêche de saisir autre chose que des chiffres : "));
        jtfInteger = new JTextField();
        jtfInteger.setPreferredSize(new Dimension(100,30));
        jtfInteger.addKeyListener(new IntegerListener());
        northPanel.add(jtfInteger);

        //container.setBackground(Color.white);
        //container.setLayout(new BorderLayout());

        //JPanel top = new JPanel();


        //top.add(label);
        //top.add(jtf);
        //top.add(b);

        add(northPanel, BorderLayout.NORTH);

        //this.setContentPane(top);
        this.setVisible(true);
    }

    class ClavierListener implements KeyListener{

        public void keyPressed(KeyEvent event) {
            System.out.println("Code touche pressée : " + event.getKeyCode() + " - caractère touche pressée : " + event.getKeyChar());
            pause();
        }

        public void keyReleased(KeyEvent event) {
            System.out.println("Code touche relâchée : " + event.getKeyCode() + " - caractère touche relâchée : " + event.getKeyChar());
            pause();
        }

        public void keyTyped(KeyEvent event) {
            System.out.println("Code touche tapée : " + event.getKeyCode() + " - caractère touche tapée : " + event.getKeyChar());
            pause();
        }
    }

    // Pour voir les événements s'afficher pas trop vite
    private void pause(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Pour empêcher qu'on puisse saisir autre chose que des chiffres
    class IntegerListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent event) {
            if(!isNumeric(event.getKeyChar()))
                jtfInteger.setText(jtfInteger.getText().replace(String.valueOf(event.getKeyChar()), ""));
        }

        //Retourne true si le paramètre est numérique, false dans le cas contraire
        private boolean isNumeric(char carac){
            try {
                Integer.parseInt(String.valueOf(carac));
            }
            catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args){
        new KeyListenerDemo();
    }
}

