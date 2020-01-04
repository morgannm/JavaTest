package SwingLab.Layout;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class LayoutTest4 extends JFrame {
    private JPanel topPanel;
    private JButton topButton;
    private JList centerList;
    private Vector<String> items;
    private JScrollPane listScrollPane;


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
        topButton = new JButton("Top button");
        topPanel.add(topButton);
        add(topPanel, BorderLayout.PAGE_START);

        // Liste centrale
        items = new Vector<>();
        for(int i=0;i<10;i++) {
            items.add("Item #" + i);
        }
        centerList = new JList(items);
        centerList.setBorder(BorderFactory.createLineBorder(Color.black)); // bordure de la liste

        // zone déroulante de la liste
        listScrollPane = new JScrollPane(centerList);
        listScrollPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // espace autour de la zone déroulante
        add(listScrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        LayoutTest4 lt = new LayoutTest4();
    }
}
