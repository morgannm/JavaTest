package SwingLab.JMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuDemo extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFichier = new JMenu("Fichier");
    private JMenu menuSousFichier = new JMenu("Sous ficher");
    private JMenu menuEdition = new JMenu("Edition");

    private JMenuItem menuItemOuvrir = new JMenuItem("Ouvrir",'O');
    private JMenuItem menuItemQuitter = new JMenuItem("Quitter");
    private JMenuItem menuItemLancer = new JMenuItem("Lancer");
    private JMenuItem menuItemArreter = new JMenuItem("Arrêter");

    private JCheckBoxMenuItem jcmi1 = new JCheckBoxMenuItem("Choix 1");
    private JCheckBoxMenuItem jcmi2 = new JCheckBoxMenuItem("Choix 2");

    private JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("Radio 1");
    private JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("Radio 2");

    // Menu contextuel
    private JPopupMenu popupMenu = new JPopupMenu();
    private JMenuItem popupMenuItemOuvrir = new JMenuItem("Ouvrir");
    private JMenuItem popupMenuItemQuitter = new JMenuItem("Quitter");

    // Listeners globaux qui serviront à la fois aux options du menu et du menu contextuel
    private OuvrirListener ouvrirListener = new OuvrirListener();
    private LancerListener lancerListener = new LancerListener();
    private QuitterListener quitterListener = new QuitterListener();

    JPanel centerPanel = new JPanel(); // panneau central sur lequel on gèrera le clic droit pour afficher le menu contextuel

    // Barre d'outils
    private JToolBar toolBar = new JToolBar();
    // Boutons de la barre d'outils
    private JButton openToolButton = new JButton(new ImageIcon("resources/openFileIcon.png")),
        lancerToolButton = new JButton(new ImageIcon("resources/playIcon.png")),
        arreterToolButton = new JButton(new ImageIcon("resources/stopIcon.png")),
        editionToolButton = new JButton(new ImageIcon("resources/printIcon.png")),
        quitterToolButton = new JButton(new ImageIcon("resources/deleteIcon.png"));

    public static void main(String[] args){
        MenuDemo menuDemo = new MenuDemo();
    }

    public MenuDemo(){
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Mnémoniques : permet d'activer les menus par Alt + Mnemonique
        menuFichier.setMnemonic('F');
        menuEdition.setMnemonic('E');

        // Accélérateur : active directement une option de menu sans ouvrir le menu correspondant
        menuItemOuvrir.setAccelerator(KeyStroke.getKeyStroke('o')); // touche 'o'
        menuItemLancer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK)); // CTRL + L

        // Actions à exécuter
        menuItemOuvrir.addActionListener(ouvrirListener);
        menuItemLancer.addActionListener(lancerListener);

        // Menu "Sous-Fichier" du menu "Fichier"
        // Options de check box
        this.menuSousFichier.add(jcmi1);
        this.menuSousFichier.add(jcmi2);
        this.menuSousFichier.addSeparator(); //Ajout d'un séparateur
        // Options de boutons radios
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrmi1);
        bg.add(jrmi1);
        jrmi1.setSelected(true); //On présélectionne la première radio
        this.menuSousFichier.add(jrmi1);
        this.menuSousFichier.add(jrmi2);

        // Ajout des options du menu "Fichier"
        this.menuFichier.add(menuItemOuvrir);
        this.menuFichier.add(this.menuSousFichier);
        this.menuFichier.addSeparator(); //Ajout d'un séparateur
        /*
        menuItemFermer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        */
        menuItemQuitter.addActionListener(quitterListener);
        this.menuFichier.add(menuItemQuitter);

        // Ajout des options du menu "Edition"
        this.menuEdition.add(menuItemLancer);
        this.menuEdition.add(menuItemArreter);

        //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
        //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
        this.menuBar.add(menuFichier);
        this.menuBar.add(menuEdition);

        this.setJMenuBar(menuBar);

        // Menu contextuel
        popupMenuItemOuvrir.addActionListener(ouvrirListener);
        popupMenuItemQuitter.addActionListener(quitterListener);
        // Listener pour ouvrir le menu contextuel quand on fait un clic droit sur centerPanel
        centerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent event) {
                // Seulement s'il s'agit d'un clic droit
                if (event.isPopupTrigger()) {
                    popupMenu.add(popupMenuItemOuvrir);
                    popupMenu.add(popupMenuItemQuitter);
                    popupMenu.show(centerPanel, event.getX(), event.getY());
                }
            }
        });

        centerPanel.add(new JLabel("Clic droit pour ouvrir le menu contextuel"));
        this.add(centerPanel, BorderLayout.CENTER);

        // Initialisation de la barre d'outils
        toolBar.add(openToolButton);
        openToolButton.addActionListener(ouvrirListener);
        toolBar.add(lancerToolButton);
        lancerToolButton.addActionListener(lancerListener);
        toolBar.add(arreterToolButton);
        toolBar.add(editionToolButton);
        toolBar.add(quitterToolButton);
        quitterToolButton.addActionListener(quitterListener);
        this.add(toolBar, BorderLayout.NORTH);

        this.setVisible(true);
    }

    class OuvrirListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane jOptionPane = new JOptionPane();
            jOptionPane.showMessageDialog(null, "Menu Ouvrir", "Menu", JOptionPane.WARNING_MESSAGE);
        }
    }

    class LancerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane jOptionPane = new JOptionPane();
            jOptionPane.showMessageDialog(null, "Menu Lancer", "Menu", JOptionPane.WARNING_MESSAGE);
        }
    }

    class QuitterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}