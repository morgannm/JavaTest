package SwingLab.JTree;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.File;

public class JTreeDemoOpenClassRooms extends JFrame {

    private JTree arbre;
    private DefaultMutableTreeNode racine;
    private Panneau panneau = new Panneau();

    public JTreeDemoOpenClassRooms(){
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Les arbres");
        //On invoque la méthode de construction de l'arbre
        listRoot();

        this.setVisible(true);
    }

    private void listRoot(){
        this.racine = new DefaultMutableTreeNode();
        int count = 0;
        for(File file : File.listRoots()){
            DefaultMutableTreeNode lecteur = new DefaultMutableTreeNode(file.getAbsolutePath());
            try {
                for(File nom : file.listFiles()){
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(nom.getName()+"\\");
                    lecteur.add(this.listFile(nom, node));
                }
            } catch (NullPointerException e) {}

            this.racine.add(lecteur);
        }
        //Nous créons, avec notre hiérarchie, un arbre
        arbre = new JTree(this.racine);
        arbre.setRootVisible(false);
        arbre.addTreeSelectionListener(new TreeSelectionListener(){
            public void valueChanged(TreeSelectionEvent event) {
                if(arbre.getLastSelectedPathComponent() != null){
                    //System.out.println(getAbsolutePath(event.getPath()));
                    //La méthode getPath retourne un objet TreePath
                    File file= new File(getAbsolutePath(event.getPath()));
                    panneau.setTexte(getDescription(file));
                }
            }

            private String getAbsolutePath(TreePath treePath){
                String str = "";
                //On balaie le contenu de l'objet TreePath
                for(Object name : treePath.getPath()){
                    //Si l'objet a un nom, on l'ajoute au chemin
                    if(name.toString() != null)
                        str += name.toString();
                }
                return str;
            }

            /**
             * Retourne une description d'un objet File
             * @param file
             * @return
             */
            private String getDescription(File file){
                String str = "Chemin d'accès sur le disque : \n\t" + file.getAbsolutePath() + "\n";
                str += (file.isFile()) ? "Je suis un fichier.\nJe fais " + file.length() + " ko\n" : "Je suis un dossier.\n";
                str += "J'ai des droits : \n";
                str += "\t en lecture : " + ((file.canRead()) ? "Oui;" : "Non;");
                str += "\n\t en écriture : " + ((file.canWrite()) ? "Oui;" : "Non;");
                return str;
            }
        });

        //séparateur de conteneur
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(arbre), new JScrollPane(panneau));
        //On place le séparateur
        split.setDividerLocation(200);
        //On ajoute le tout
        this.getContentPane().add(split, BorderLayout.CENTER);
    }

    private DefaultMutableTreeNode listFile(File file, DefaultMutableTreeNode node){
        int count = 0;
        if(file.isFile())
            return new DefaultMutableTreeNode(file.getName());
        else{
            File[] list = file.listFiles();
            if(list == null)
                return new DefaultMutableTreeNode(file.getName());

            for(File nom : list){
                count++;
                //Pas plus de 5 enfants par noeud
                if(count < 5){
                    DefaultMutableTreeNode subNode;
                    if(nom.isDirectory()){
                        subNode = new DefaultMutableTreeNode(nom.getName()+"\\");
                        node.add(this.listFile(nom, subNode));
                    }else{
                        subNode = new DefaultMutableTreeNode(nom.getName());
                    }
                    node.add(subNode);
                }
            }
            return node;
        }
    }

    public static void main(String[] args){
        JTreeDemoOpenClassRooms fen = new JTreeDemoOpenClassRooms();
    }

    // Panneau de détail d'un élément sélectionné dans l'arbre
    class Panneau extends JPanel {
        private String texte="Racine de l'arbre";
        private JTextArea jta;

        public Panneau() {
            this.jta = new JTextArea(texte);
            this.setBackground(Color.white);
            this.add(jta);
        }
        public void setTexte(String texte) { this.jta.setText(texte);}
    }
}