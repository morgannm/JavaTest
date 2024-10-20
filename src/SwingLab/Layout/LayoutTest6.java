package SwingLab.Layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayoutTest6 extends JFrame implements ActionListener {
    private JPanel topPanel;
    private JButton topButton;
    private JList centerList;
    private JScrollPane listScrollPane;
    private DefaultListModel<String> items;
    private JButton validerButton;
    private JButton annulerButton;
    private JTextArea coupsTextArea;

    public LayoutTest6() {
        super("LayoutTest6");
        Init();
    }

    private void Init() {
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Centre de la fenêtre -------------------------------------------------------
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // bordure autour du groupe
        // pour que le label soit en haut à gauche du groupe, on le met dans un JPanel
        JPanel labelLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelLeftPanel.setBorder(BorderFactory.createEmptyBorder(0,0,5,20));
        labelLeftPanel.add(new JLabel("Coups"));
        centerPanel.add(labelLeftPanel, BorderLayout.WEST); // Panel contenant le texte à gauche

        coupsTextArea = new JTextArea(20,60);
        coupsTextArea.setLineWrap(true);
        coupsTextArea.setText("1. e2e4 c7c5 2. c2c4 Nb8c6 3. b2b3 Ng8f6 4. d2d3 g7g6 5. g2g4 d7d6 6. Bf1h3 Bf8g7 7. Bc1b2 O-O 8. Ng1f3 Bc8xg4 9. Bh3xg4 Nf6xg4 10. d3d4 c5xd4 11. Nf3xd4 Ng4f6 12. a2a4 Nf6xe4 13. Nd4xc6 b7xc6 14. Bb2xg7 Kg8xg7 15. Qd1d4+ Ne4f6 16. Nb1a3 Qd8a5+ 17. Qd4d2 Qa5e5+ 18. Qd2e3 Qe5xa1+ 19. Ke1e2 Qa1xh1 20. Qe3xe7 Qh1e4+ 21. Qe7xe4 Nf6xe4 22. f2f3 Ne4f6 23. Na3c2 Rf8e8+ 24. Nc2e3 Ra8b8 25. b3b4 Rb8xb4 26. Ke2d3 Rb4b3+ 27. Kd3d4 Re8xe3 28. c4c5 d6d5 29. h2h4 Rb3d3# 0-1");
        centerPanel.add(coupsTextArea, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Partie inférieure de la fenêtre ----------------------------------------------------
        JPanel bottomPanel = new JPanel(new BorderLayout());
        // 2 boutons radio à gauche
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup langues = new ButtonGroup();
        JRadioButton francaisRadioButton = new JRadioButton("Français", true);
        JRadioButton anglaisRadioButton = new JRadioButton("Anglais", true);
        langues.add(francaisRadioButton);
        langues.add(anglaisRadioButton);
        radioPanel.add(francaisRadioButton);
        radioPanel.add(anglaisRadioButton);
        bottomPanel.add(radioPanel,BorderLayout.WEST);
        // 2 boutons de commande à droite
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        validerButton = new JButton("Valider");
        validerButton.addActionListener(this);
        buttonPanel.add(validerButton);
        annulerButton = new JButton("Annuler");
        annulerButton.addActionListener(this);
        buttonPanel.add(annulerButton);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

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
        LayoutTest6 lt = new LayoutTest6();
    }

}
