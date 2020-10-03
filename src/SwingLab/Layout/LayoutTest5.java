package SwingLab.Layout;

import javax.naming.spi.DirectoryManager;
import javax.swing.*;
import java.awt.*;

// Layout avec des groupes de contrôles superposés
public class LayoutTest5 extends JFrame {
    public LayoutTest5() {
        super("LayoutTest5");
        Init();
    }

    private void Init() {
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.PAGE_AXIS)); // les contrôles positionnés à l'intérieur seront superposés verticalement

        northPanel.add(new JLabel("Groupes de contrôles tassés verticalement"));

        // 1er groupe de contrôles : tassés à gauche
        JPanel filePanel = new JPanel();
        filePanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // les contrôles sont tassés à gauche
        filePanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        filePanel.add(new JLabel("Fichier : "));
        JTextField txtFichier = new JTextField("");
        txtFichier.setPreferredSize(new Dimension(400,25));
        filePanel.add(txtFichier);
        filePanel.add(new JButton("..."));
        northPanel.add(filePanel);

        // 2ème groupe de contrôles : un label à gauche et une liste qui prend le reste de l'espace
        JPanel contentFilePanel = new JPanel(new BorderLayout()); // BorderLayout : layout par défaut avec les zones North, Center, South, ...
        contentFilePanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        JPanel contentFilePanelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // pour que le label soit en haut à gauche du groupe, on le met dans un JPanel
        contentFilePanelLeft.add(new JLabel("Contenu du fichier : "));
        contentFilePanel.add(contentFilePanelLeft, BorderLayout.LINE_START); // label à gauche
        JList list = new JList(new DefaultListModel());
        JScrollPane listScrollPane = new JScrollPane(list);
        contentFilePanel.add(listScrollPane, BorderLayout.CENTER); // la liste occupe le reste de l'espace vers la droite
        northPanel.add(contentFilePanel);

        add(northPanel, BorderLayout.NORTH); // les groupes de contrôles sont tassés vers le haut

        // Groupe de contrôle prenant le reste de l'espace
        JPanel optimPanel = new JPanel(new BorderLayout());
        optimPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        // pour que le bouton n'occupe pas toute la hauteur sur la gauche, on le met dans un JPanel
        JPanel optimLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        optimLeftPanel.add(new JButton("Optimisation"));
        optimPanel.add(optimLeftPanel, BorderLayout.LINE_START); // Panel contenant le bouton à gauche
        optimPanel.add(new JScrollPane(new JList()), BorderLayout.CENTER);
        add(optimPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        LayoutTest5 lt = new LayoutTest5();
    }

}
