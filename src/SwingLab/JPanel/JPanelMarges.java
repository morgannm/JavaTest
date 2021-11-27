package SwingLab.JPanel;

import SwingLab.Layout.LayoutTest;

import javax.swing.*;
import java.awt.*;

public class JPanelMarges extends JFrame {
    public JPanelMarges() {
        super("LayoutTest");
        setSize(600, 300);
        setLocationRelativeTo(null); // centrer la fenêtre

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));

        // Panel contenant des checkboxes
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        checkBoxPanel.setBackground(Color.ORANGE);
        JCheckBox checkBox1 = new JCheckBox("Check box 1");
        checkBoxPanel.add(checkBox1);
        JLabel label1 = new JLabel("Panel avec espacement intérieur par défaut (FlowLayout)");
        checkBoxPanel.add(label1);
        mainPanel.add(checkBoxPanel);

        // Panel sans padding
        JPanel checkBoxPanel2 = new JPanel();
        FlowLayout flo = new FlowLayout(FlowLayout.LEFT);
        flo.setVgap(0); // pas d'espace intérieur vertical
        flo.setHgap(0); // pas d'espace intérieur horizontal
        checkBoxPanel2.setLayout(flo);
        checkBoxPanel2.setBackground(Color.cyan);
        JCheckBox checkBox2 = new JCheckBox("Check box 2");
        checkBoxPanel2.add(checkBox2);
        JLabel label2 = new JLabel("Espacement horizontal et vertical du FlowLayout à 0");
        checkBoxPanel2.add(label2);
        mainPanel.add(checkBoxPanel2);

        // Panel
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.PINK);
        mainPanel.add(panel3);

        add(mainPanel, BorderLayout.NORTH);
        setVisible(true);

    }

    public static void main(String[] arguments) {
        JPanelMarges lt = new JPanelMarges();
    }

}
