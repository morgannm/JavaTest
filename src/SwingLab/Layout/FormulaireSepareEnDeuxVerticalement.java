package SwingLab.Layout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FormulaireSepareEnDeuxVerticalement extends JFrame {
    private static final String IMG_PATH = "DepecheMode_BlackCelebration.jpg";

    // Formulaire de saisie avec des contrôles alignés dont la hauteur ne varie pas avec la taille de la fenêtre
    public FormulaireSepareEnDeuxVerticalement() throws IOException {
        super("Formulaire de saisie séparé en deux verticalement");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // pour centrer la fenêtre

        // Formulaire de saisie
        JPanel formulairePanel = new JPanel();
        formulairePanel.setLayout(new GridLayout(4,2,5,5));
        formulairePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        formulairePanel.add(new JLabel("Artiste : "));
        JTextField blancsTextField = new JTextField();
        formulairePanel.add(blancsTextField);
        formulairePanel.add(new JLabel("Artiste pour tri : "));
        formulairePanel.add(new JTextField());
        formulairePanel.add(new JLabel("Album : "));
        formulairePanel.add(new JTextField());
        formulairePanel.add(new JLabel("Interprète : "));
        formulairePanel.add(new JTextField());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout()); // indispensable pour que les contrôles de saisie occupent toute la largeur
        leftPanel.add(formulairePanel,BorderLayout.NORTH);  // contrôles tassés en haut mais n'occupant pas toute la largeur

        // Partie droite : image
        JPanel imagePanel = new JPanel();
        BufferedImage img = ImageIO.read(new File(IMG_PATH));
        Image scaledImage = img.getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(scaledImage);
        JLabel image = new JLabel(icon);
        imagePanel.add(image,BorderLayout.CENTER);

        // Boutons de commande en bas
        JPanel commandPanel = new JPanel();
        JButton okButton = new JButton("Ok");
        JButton annulerButton = new JButton("Annuler");
        commandPanel.add(okButton);
        commandPanel.add(annulerButton);

        // Solution 1 : Partie formulaire à largeur variable sur tout l'espace disponible à gauche
        add(leftPanel, BorderLayout.CENTER); // occupe tout le reste de la largeur et s'adapte à la largeur de la fenêtre
        add(imagePanel, BorderLayout.EAST); // largeur fixe

        // Solution 2 : Même largeur pour la partie formulaire à gauche et la partie de droite contenant l'image (dont la taille est fixe)
        /*
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1,2,5,10)); // tableau 1 ligne, 2 colonnes, espace horizontal entre les contrôles, espace vertical
        centerPanel.add(leftPanel);
        centerPanel.add(imagePanel);
        add(centerPanel,BorderLayout.CENTER);
         */

        add(commandPanel, BorderLayout.SOUTH);

        setVisible(true);

    }

    public static void main(String[] arguments) throws IOException {
        FormulaireSepareEnDeuxVerticalement lt = new FormulaireSepareEnDeuxVerticalement();
    }

}
