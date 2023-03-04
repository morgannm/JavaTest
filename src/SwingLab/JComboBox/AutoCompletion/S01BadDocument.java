package SwingLab.JComboBox.AutoCompletion;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

// http://www.orbital-computer.de/JComboBox/
// Catching user input
// Ce code ne fait que montrer qu'on peut intercepter une touche pressée dans la zone de texte de la comboBox
public class S01BadDocument extends PlainDocument {

    // Méthode appelée quand on appuie sur une touche
    public void insertString(int offs, String str, AttributeSet a) {
        // reject the insert but print a message on the console
        System.out.println("insert " + str + " at " + offs);
    }

    private static void createAndShowGUI() {
        // the combo box (add/modify items if you like to)
        JComboBox comboBox = new JComboBox(new Object[] {"Ester", "Jordi", "Jordina", "Jorge", "Sergi"});
        // has to be editable
        comboBox.setEditable(true);
        // get the combo boxes editor component
        JTextComponent editor = (JTextComponent) comboBox.getEditor().getEditorComponent();
        // change the editor's document
        editor.setDocument(new S01BadDocument());

        // create and show a window containing the combo box
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.getContentPane().add(comboBox);
        frame.pack(); frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}