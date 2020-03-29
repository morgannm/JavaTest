package SwingLab.JDialog.OpenClassRooms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPersonnageDialog extends JFrame {
    private JButton bouton = new JButton("Ouverture PersonnageDialog");

    public TestPersonnageDialog(){
        this.setTitle("Ma JFrame");
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(bouton);
        bouton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                PersonnageDialog personnageDialog = new PersonnageDialog(null, "Personnage", true);
                Personnage personnage = personnageDialog.showPersonnageDialog();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, personnage.toString(), "Informations personnage", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] main){
        TestPersonnageDialog fen = new TestPersonnageDialog();
    }
}


