package SwingLab.Layout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlesSuperposes extends JFrame {
    private static final String IMG_PATH = "DepecheMode_BlackCelebration.jpg";

    // Formulaire de saisie avec des contrôles alignés dont la hauteur ne varie pas avec la taille de la fenêtre
    public ControlesSuperposes() throws IOException {
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

        // Partie droite : groupes de composants superposés
        // 1er groupe : image + bouton superposés
        // 2ème groupe : image + bouton tassés à gauche

        // Panel de regroupement pour superposer les 2 groupes de composants
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.PAGE_AXIS));

        // 1er groupe de composants
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel,BoxLayout.PAGE_AXIS));
        imagePanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        // image
        BufferedImage img = ImageIO.read(new File(IMG_PATH));
        Image scaledImage = img.getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(scaledImage);
        JLabel image = new JLabel(icon);
        imagePanel.add(image);
        // espace entre l'image et le bouton
        imagePanel.add(Box.createRigidArea(new Dimension(0,5)));
        // bouton
        JButton selectImageButton = new JButton("Sélectionner");
        imagePanel.add(selectImageButton);
        // nécessaire pour que les 2 groupes de composants sont alignés à gauche
        imagePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        // ajout du 1er groupe de composant au panel de regroupement
        rightPanel.add(imagePanel);

        // 2ème groupe de composants
        JPanel smallLogoPanel = new JPanel();
        smallLogoPanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
        // image
        BufferedImage imgSmall = ImageIO.read(new File(IMG_PATH));
        Image scaledSmallImage = img.getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon smallIcon = new ImageIcon(scaledSmallImage);
        JLabel smallImage = new JLabel(smallIcon);
        smallLogoPanel.add(smallImage);
        // bouton
        JButton selectSmallImageButton = new JButton("Sélectionner");
        smallLogoPanel.add(selectSmallImageButton);
        // nécessaire pour que les 2 groupes de composants sont alignés à gauche
        smallLogoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        // ajout du 2ème groupe de composant au panel de regroupement
        rightPanel.add(smallLogoPanel);

        // Boutons de commande en bas
        JPanel commandPanel = new JPanel();
        commandPanel.setLayout(new BorderLayout());
        JPanel leftCommandPanel = new JPanel();
        JButton precedentButton = new JButton("Précédent");
        JButton suivantButton = new JButton("Suivant");
        leftCommandPanel.add(precedentButton);
        leftCommandPanel.add(suivantButton);
        commandPanel.add(leftCommandPanel,BorderLayout.WEST);
        JPanel rightCommandPanel = new JPanel();
        JButton okButton = new JButton("Ok");
        JButton annulerButton = new JButton("Annuler");
        rightCommandPanel.add(okButton);
        rightCommandPanel.add(annulerButton);
        commandPanel.add(rightCommandPanel,BorderLayout.EAST);

        // Partie formulaire à largeur variable sur tout l'espace disponible à gauche
        add(leftPanel, BorderLayout.CENTER); // occupe tout le reste de la largeur et s'adapte à la largeur de la fenêtre
//        add(imagePanel, BorderLayout.EAST); // largeur fixe
        add(rightPanel, BorderLayout.EAST); // largeur fixe

        add(commandPanel, BorderLayout.SOUTH);

        setVisible(true);

    }

    public static void main(String[] arguments) throws IOException {
        SwingLab.Layout.ControlesSuperposes lt = new SwingLab.Layout.ControlesSuperposes();
    }

}
