package Events.AfficheTexte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by morgannm on 12/09/2016.
 */
public class Application extends JFrame implements ActionListener, MessageListener {

    JLabel labelProgress;
    JButton btnStart;
    JPanel topPanel;
    JPanel centerPanel;
    JPanel bottomPanel;

    public Application() {
        super("Evénement personnalisé pour afficher du texte");
        setLookAndFeel();
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Partie supérieure
        topPanel = new JPanel();
        FlowLayout flo1 = new FlowLayout(FlowLayout.LEFT,5,5);
        topPanel.setLayout(flo1);
        btnStart = new JButton("Démarrer");
        btnStart.addActionListener(this);
        topPanel.add(btnStart);
        add(topPanel, BorderLayout.NORTH);

        // Partie centrale
        centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        labelProgress = new JLabel("En attente...");
        centerPanel.add(labelProgress);
        add(centerPanel,BorderLayout.CENTER);

        // Partie inférieure
        bottomPanel = new JPanel();
        add(bottomPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }

    public static void main(String[] arguments) {
        Application app = new Application();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == btnStart) {
            labelProgress.setText("Démarré");
            Calcul calcul = new Calcul();
            calcul.addMessageListener(this);
            new Thread() {
                @Override public void run () {
                    calcul.Calculate();
                }
            }.start();
            //calcul.addSpeedListener();
            //System.out.println("Ok button");
        }
    }

    @Override
    public void displayMessage(String Message) {
        //labelProgress.setText(Message);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                labelProgress.setText(Message);
            }
        });
    }
}
