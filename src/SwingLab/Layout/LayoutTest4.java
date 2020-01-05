package SwingLab.Layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class LayoutTest4 extends JFrame implements ActionListener {
    private JPanel topPanel;
    private JButton topButton;
    private JList centerList;
    private JScrollPane listScrollPane;
    private DefaultListModel<String> items;


    public LayoutTest4() {
        super("LayoutTest4");
        Init();
    }

    private void Init() {
        setTitle("LayoutTest4");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BorderLayout blo = new BorderLayout();
        setLayout(blo);

        // Partie supérieure de la fenêtre
        topPanel = new JPanel();
        topButton = new JButton("Ajouter 10 éléments");
        topButton.addActionListener(this);
        topPanel.add(topButton);
        add(topPanel, BorderLayout.PAGE_START);

        // Liste centrale
        items = new DefaultListModel<>();
        for(int i=0;i<10;i++) {
            items.addElement("Item #" + i);
        }
        centerList = new JList(items);
        centerList.setBorder(BorderFactory.createLineBorder(Color.black)); // bordure de la liste

        // zone déroulante de la liste
        listScrollPane = new JScrollPane(centerList);
        listScrollPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // espace autour de la zone déroulante
        add(listScrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == topButton) {
            for(int i=10;i<20;i++) {
                items.addElement("Item #" + i);
            }
        }

    }

    public static void main(String[] args) {
        LayoutTest4 lt = new LayoutTest4();
    }

}
