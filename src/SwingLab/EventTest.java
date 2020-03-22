package SwingLab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// TestThread1 de gestion d'événements sur les contrôles de saisie
public class EventTest extends JFrame implements ItemListener, ActionListener {
    
    JPanel inputPanel;
    JPanel commandPanel;
    JPanel centerPanel;
    JLabel nomLabel;
    JTextField nomTextField;
    JLabel adminLabel;
    JCheckBox adminCheckBox;
    JButton okButton;
    JButton cancelButton;
    JLabel resultLabel;

    public EventTest() {
        super("Event TestThread1");
        setLookAndFeel();
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout blo = new BorderLayout();
        setLayout(blo);
        
        inputPanel = new JPanel();
        inputPanel.setBackground(Color.BLUE);
        GridLayout layout1 = new GridLayout(2, 2, 10, 10);
        inputPanel.setLayout(layout1);
        nomLabel = new JLabel("Nom :");
        inputPanel.add(nomLabel);
        nomTextField = new JTextField(30);
        inputPanel.add(nomTextField);
        adminLabel = new JLabel("Administrateur :");
        inputPanel.add(adminLabel);
        adminCheckBox = new JCheckBox("Administrateur");
        adminCheckBox.addItemListener(this);
        inputPanel.add(adminCheckBox);        
        add(inputPanel,BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.orange);
        JLabel label = new JLabel("Résultat :"); 
        resultLabel = new JLabel();
        FlowLayout centerLayout = new FlowLayout(FlowLayout.LEFT, 10, 10);
        resultLabel.setLayout(centerLayout);
        centerPanel.add(label);
        centerPanel.add(resultLabel);
        add(centerPanel,BorderLayout.CENTER);
        
        commandPanel = new JPanel();
        commandPanel.setBackground(Color.green);
        FlowLayout commandLayout = new FlowLayout(FlowLayout.RIGHT, 10, 10);
        commandPanel.setLayout(commandLayout);
        okButton = new JButton("Ok");
        okButton.addActionListener(this);
        commandPanel.add(okButton);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        commandPanel.add(cancelButton);
        add(commandPanel,BorderLayout.SOUTH);        
        
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }
    
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == okButton) {
            resultLabel.setText("Ok");
            System.out.println("Ok button");
        } else if (source == cancelButton) {
            resultLabel.setText("Cancel");
        } else {
            // start caused event
        }
    }

     public void itemStateChanged(ItemEvent event) {
        Object item = event.getItem();
        if (item == adminCheckBox) {
            JCheckBox chk = (JCheckBox)item;
            if (chk.isSelected())
            {
                resultLabel.setText("Administrateur");            
            }
            else
            {
                resultLabel.setText("Non administrateur");            
            }
        } else {
        }
    }
     
    public static void main(String[] arguments) {
        EventTest frm = new EventTest();
    }
}
