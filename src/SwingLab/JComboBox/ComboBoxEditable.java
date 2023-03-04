package SwingLab.JComboBox;

import SwingLab.JComboBox.AutoCompletion.S01BadDocument;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ComboBoxEditable extends JFrame {

    private ComboBoxAutoCompletion compositeursComboBox;
    private ComboBoxAutoCompletion genresComboBox;

    public ComboBoxEditable() {
        setTitle("ComboBox Editable");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(3,2,5,5));
        northPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        northPanel.add(new JLabel("Compositeur : "));
        compositeursComboBox = new ComboBoxAutoCompletion();
        for (String compositeur : getCompositeurs()) compositeursComboBox.addItem(compositeur);
        compositeursComboBox.setSelectedIndex(-1);
        northPanel.add(compositeursComboBox);

        northPanel.add(new JLabel("Genre : "));
        genresComboBox = new ComboBoxAutoCompletion();
        for (String genre : getGenres()) genresComboBox.addItem(genre);
        genresComboBox.setSelectedIndex(-1);
        northPanel.add(genresComboBox);

        this.add(northPanel,BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        ComboBoxEditable comboBoxEditable = new ComboBoxEditable();
    }

    private List<String> getCompositeurs() {
        List<String> compositeurs = new ArrayList<>();
        compositeurs.add("Albeniz");
        compositeurs.add("Bach");
        compositeurs.add("Beethoven");
        compositeurs.add("Berlioz");
        compositeurs.add("Debussy");
        compositeurs.add("Haendel");
        compositeurs.add("Haydn");
        compositeurs.add("Mendelssohn");
        compositeurs.add("Mozart");
        compositeurs.add("Prokofiev");
        compositeurs.add("Vivaldi");
        return compositeurs;
    }

    private List<String> getGenres() {
        List<String> genres = new ArrayList<>();
        genres.add("Aria");
        genres.add("Boléro");
        genres.add("Cantate");
        genres.add("Concerto");
        genres.add("Etude");
        genres.add("Fugue");
        genres.add("Menuet");
        genres.add("Opéra");
        genres.add("Oratorio");
        genres.add("Ouverture");
        genres.add("Requiem");
        genres.add("Sonate");
        genres.add("Suite");
        genres.add("Symphonie");
        genres.add("Te Deum");
        genres.add("Toccata");
        return genres;
    }

    private class ComboBoxAutoCompletion extends JComboBox {
        public ComboBoxAutoCompletion() {
            this.setEditable(true);
            JTextComponent editor = (JTextComponent) this.getEditor().getEditorComponent();
            // change the editor's document
            editor.setDocument(new ComboBoxAutoCompletionEditDocument(this));

        }
    }

    private class ComboBoxAutoCompletionEditDocument extends PlainDocument {
        JComboBox comboBox;
        ComboBoxModel model;
        JTextComponent editor;

        // mis à true pour indiquer qu'on est en train d'exécuter insertString,
        //  et pour éviter que la méthode sot rappelée automatiquement quand setSelectedItem est appelée
        //  pour sélectionner l'élément trouvé par rapport aux premières lettres tapées
        boolean selecting = false;

        public ComboBoxAutoCompletionEditDocument(final JComboBox comboBox) {
            this.comboBox = comboBox;
            this.model = comboBox.getModel();
            editor = (JTextComponent) comboBox.getEditor().getEditorComponent();

            // Affiche la liste dès qu'on tape quelque chose
            editor.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (comboBox.isDisplayable()) comboBox.setPopupVisible(true);
                }
            });
        }

        // Méthode appelée quand on appuie sur une touche
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (selecting) return; // on est déjà dans insertString (appélé automatiquement par selSelectedItem)

            System.out.println("insert " + str + " at " + offs);
            // insert the string into the document
            super.insertString(offs, str, a);

            // cherche un élément qui commence par les lettres tapées
            Object item = lookupItem(getText(0, getLength()));
            if (item!=null) {
                setSelectedItem(item); // sélectionne l'élément trouvé dans le model

                // remplace le texte existant par l'élément trouvé
                super.remove(0, getLength());
                super.insertString(0, item.toString(), a);

                // sélectionne la partie du texte qui se trouve après ce qui a déjà été tapé => permet de continuer à taper la suite pour se positionner sur un autre élément
                // si celui qui a été sélectionné n'est pas celui qu'on cherche
                JTextComponent editor = (JTextComponent) comboBox.getEditor().getEditorComponent();
                editor.setSelectionStart(offs+str.length());
                editor.setSelectionEnd(getLength());

            }
        }

        // sélectionne un élément dans le model lié à la comboBox
        private void setSelectedItem(Object item) {
            selecting = true;
            model.setSelectedItem(item);
            selecting = false;
        }

        @Override
        public void remove(int offs, int len) throws BadLocationException {
            if (selecting) return;
            super.remove(offs, len);
        }

/*
        private Object lookupItem(String pattern) {
            Object selectedItem = model.getSelectedItem();
            // only search for a different item if the currently selected does not match
            if (selectedItem != null && startsWithIgnoreCase(selectedItem.toString(), pattern)) {
                System.out.println("Selected item '" + selectedItem + "' matches '" + pattern + "'");
                return selectedItem;
            } else {
                // iterate over all items
                for (int i=0, n=model.getSize(); i < n; i++) {
                    Object currentItem = model.getElementAt(i);
                    // current item starts with the pattern?
                    if (startsWithIgnoreCase(currentItem.toString(), pattern)) {
                        System.out.println("New selection: '" + currentItem + "'");
                        return currentItem;
                    }
                }
            }
            // no item starts with the pattern => return null
            return null;
        }
*/

        // cherche dans le model, un élément qui commence par 'pattern'
        private Object lookupItem(String pattern) {
            // iterate over all items
            for (int i=0, n=model.getSize(); i < n; i++) {
                Object currentItem = model.getElementAt(i);
                // current item starts with the pattern?
                if (startsWithIgnoreCase(currentItem.toString(), pattern)) {
                    System.out.println("'" + currentItem + "' matches pattern '" + pattern + "'");
                    return currentItem;
                }
            }
            // no item starts with the pattern => return null
            return null;
        }

        // checks if str1 starts with str2 - ignores case
        private boolean startsWithIgnoreCase(String str1, String str2) {
            return str1.toUpperCase().startsWith(str2.toUpperCase());
        }
    }
}
