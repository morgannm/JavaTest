package SwingLab.JList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListDemo2 extends JFrame implements ActionListener {
    private JList list;
    private DefaultListModel listModel;

    private JPanel topPanel;
    private JButton deleteButton;
    private JButton addButton;
    private int i=0;

    public ListDemo2() {
        super("ListDemo2");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BorderLayout blo = new BorderLayout();
        setLayout(blo);

        // Partie supérieure de la fenêtre
        topPanel = new JPanel();
        addButton = new JButton("Ajoute un élément à la liste");
        addButton.addActionListener(this);
        topPanel.add(addButton);

        deleteButton = new JButton("Supprime l'élément sélectionné");
        deleteButton.addActionListener(this);
        topPanel.add(deleteButton);
        add(topPanel, BorderLayout.PAGE_START);

        listModel = new DefaultListModel();
        listModel.addElement("Jane Doe");
        listModel.addElement("John Smith");
        listModel.addElement("Kathy Green");

        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setBorder(BorderFactory.createLineBorder(Color.black)); // bordure de la liste

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // espace autour de la zone déroulante

        add(listScrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addButton) {
            i++;
            listModel.addElement("Item #" + i);
        }
        else if (source == deleteButton) {
            int index = list.getSelectedIndex();
            listModel.remove(index);
            int size = listModel.getSize();
            if (size == 0) {
                deleteButton.setEnabled(false);
            } else { //Select an index.
                if (index == listModel.getSize()) {
                    //removed item in last position
                    index--;
                }
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        }
    }

    public static void main(String[] args) {
        ListDemo2 lst = new ListDemo2();
    }
}

