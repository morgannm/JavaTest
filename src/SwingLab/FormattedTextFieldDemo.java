package SwingLab;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

public class FormattedTextFieldDemo extends JFrame {
    private JPanel container = new JPanel();

    // seuls les chiffres sont conservés quand on quitte la zone
    private JFormattedTextField jtfInteger = new JFormattedTextField(NumberFormat.getIntegerInstance());

    // ne conserve que les saisies avec des chiffres + espace + '%'
    private JFormattedTextField jtfPercent = new JFormattedTextField(NumberFormat.getPercentInstance());

    // nombres avec décimales ','
    private JFormattedTextField jtfNumber = new JFormattedTextField(NumberFormat.getNumberInstance());

    // formattage d'un numéro de téléphone
    private JFormattedTextField jtfTel;

    private JButton OkButton = new JButton ("OK");

    public FormattedTextFieldDemo(){
        this.setTitle("FormattedTextField Demo");
        this.setSize(800, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Partie supérieure avec les contrôles de saisie
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(4,2,5,5));
        northPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        northPanel.add(new JLabel("JFormattedTextField(NumberFormat.getIntegerInstance()) : "));
        jtfInteger.setPreferredSize(new Dimension(150, 30));
        northPanel.add(jtfInteger);

        northPanel.add(new JLabel("JFormattedTextField(NumberFormat.getPercentInstance()) : "));
        jtfPercent.setPreferredSize(new Dimension(150, 30));
        northPanel.add(jtfPercent);

        northPanel.add(new JLabel("JFormattedTextField(NumberFormat.getNumberInstance()) : "));
        jtfNumber.setPreferredSize(new Dimension(150, 30));
        northPanel.add(jtfNumber);

        northPanel.add(new JLabel("JFormattedTextField(MaskFormatter) : "));
        try {
            MaskFormatter tel = new MaskFormatter("## ## ## ## ##");
            jtfTel = new JFormattedTextField(tel);
            northPanel.add(jtfTel);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        // Boutons de commande en bas
        JPanel bottomPanel = new JPanel();
        OkButton.addActionListener(new BoutonListener());
        bottomPanel.add(OkButton);

        // Ajout des Panel à la fenêtre
        add(northPanel, BorderLayout.NORTH); // NB : si on ajoute le Panel dans CENTER, la hauteur des contrôles de saisie est ajustée pour occuper tout l'espace disponible
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);

        //container.setLayout(new BorderLayout());
        //JPanel top = new JPanel();
        //Font police = new Font("Arial", Font.BOLD, 14);
        //this.setContentPane(top);
        this.setVisible(true);
    }

    class BoutonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("TEXT : jtfInteger " + jtfInteger.getText());
            System.out.println("TEXT : jtfPercent " + jtfPercent.getText());
        }
    }

    public static void main(String[] args) {
        FormattedTextFieldDemo formattedTextFieldDemo = new FormattedTextFieldDemo();
    }
}
