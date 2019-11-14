package SwingLab.JTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeDemo {
    public static void main(String[] args) {
        JFrame fenetre = new JFrame();
        fenetre.setLocationRelativeTo(null);
        fenetre.setSize(300, 400);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Racine");
        DefaultMutableTreeNode element = new DefaultMutableTreeNode("Elémént 1");
        root.add(element);
        element = new DefaultMutableTreeNode("Elémént 2");
        DefaultMutableTreeNode sousElement = new DefaultMutableTreeNode("Sous-Elémént 1");
        element.add(sousElement);
        root.add(element);
        fenetre.add(new JScrollPane(new JTree(root)));

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);

    }
}
