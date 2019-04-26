package SwingLab;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Morgann on 03/07/2016.
 * JList affichant une liste d'objets triée selon une propriété
 */
public class ListDemoVectorObjets extends JFrame implements ListSelectionListener {
    public static void main(String[] args) {
        ListDemoVectorObjets demo = new ListDemoVectorObjets();
    }

    private JList list;
    private JTextField txtItem;

    public ListDemoVectorObjets() {
        super("ListDemoVectorObjets");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Random randomGenerator = new Random();
        Vector<Estimate> estimates = new Vector<Estimate>();
        for (int i=1; i<=100; i++) {
            estimates.add(new Estimate(Integer.toString(i),"Test" + i,randomGenerator.nextInt(1000),randomGenerator.nextInt(2000)));
        }
        //Collections.sort(estimates); // tri de estimates => utilise compareTo qui trie sur la quantité
        /*
        Collections.sort(estimates, new Comparator<Estimate>() {
            public  int compare(Estimate e1, Estimate e2) {
                if (e1.getQuantite()<e2.getQuantite())
                    return -1;
                else if (e1.getQuantite()>e2.getQuantite())
                    return 1;
                else
                    return 0;
            }
        });
        */
        Collections.sort(estimates, new Comparator<Estimate>() {
            public  int compare(Estimate e1, Estimate e2) {
                if (e1.getQuantite2()<e2.getQuantite2())
                    return -1;
                else if (e1.getQuantite2()>e2.getQuantite2())
                    return 1;
                else
                    return 0;
            }
        });

        list = new JList(estimates);

        /* Par défaut JList utilise la méthode toString de l'objet pour afficher les données
           Mais on peut aussi personnaliser l'affichage avec un CellRenderer */
        /*
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Estimate) {
                    ((JLabel) renderer).setText(((Estimate) value).getShortDescription());
                }
                return renderer;
            }
        });
        */

        // Clic sur un élément de la liste
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                JList list = (JList)mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    // Double-click detected
                    Estimate esti = (Estimate)list.getSelectedValue(); // objet sélectionné
                    JLabel label = new JLabel("Vous avez double cliqué sur le devis n° " + esti.getNumero());
                    JOptionPane.showMessageDialog(null, label);
                }
            }
        });


        add(new JScrollPane(list), BorderLayout.CENTER);

        txtItem = new JTextField("");
        add(txtItem, BorderLayout.PAGE_END);

        list.addListSelectionListener(this); // ajoute le gestionnaire d'événement de changement de sélection dans la liste

        setVisible(true);
    }

    // Méthode déclenchée quand la sélection de la liste change
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object source = e.getSource();
        if (source == list)
        {
            Estimate esti = (Estimate) list.getSelectedValue();
            txtItem.setText(esti.getNumero());
        }
    }

    private class Estimate implements Comparable<Estimate> {
        public String Numero;
        public String Reference;
        public int Quantite;
        public int Quantite2;

        public Estimate(String Numero, String Reference, int Quantite, int Quantite2) {
            this.setNumero(Numero);
            this.setReference(Reference);
            this.setQuantite(Quantite);
            this.setQuantite2(Quantite2);
        }

        public String getNumero() {
            return Numero;
        }

        public void setNumero(String numero) {
            Numero = numero;
        }

        public String getReference() {
            return Reference;
        }

        public void setReference(String reference) {
            Reference = reference;
        }

        public int getQuantite() {
            return Quantite;
        }

        public void setQuantite(int quantite) {
            Quantite = quantite;
        }

        public int getQuantite2() {
            return Quantite2;
        }

        public void setQuantite2(int quantite2) {
            Quantite2 = quantite2;
        }

        // Méthode utilisée par défaut par JList pour afficher les données
        public String toString() {
            return getNumero() + " - " + getReference() + " - " + getQuantite() + " - " + getQuantite2();
        }

        // Méthode utilisée par le custom cell renderer
        public String getShortDescription() {
            return getNumero() + " - " + getReference() + " - " + getQuantite();
        }

        @Override
        public int compareTo(Estimate o) {
            if (Quantite<o.Quantite)
                return -1;
            else if (Quantite>o.Quantite)
                return 1;
            else
                return 0;
        }
    }
}

