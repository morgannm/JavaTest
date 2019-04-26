package SwingLab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by morga on 14/08/2018.
 * Test de rafraîchissement de l'interface utilisateur au cours d'un traitement long
 */
public class SwingWorkerDemo extends JFrame implements ActionListener {
    private JButton testButton;
    private JLabel statusLabel;

    public static void main(String[] args) {
        SwingWorkerDemo swingWorkerDemo = new SwingWorkerDemo();
    }

    public SwingWorkerDemo() {
        super("SwingWorkerDemo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flo = new FlowLayout();
        setLayout(flo);

        testButton = new JButton("Test");
        testButton.addActionListener(this);
        add(testButton);
        statusLabel = new JLabel();
        add(statusLabel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == testButton) {
            (new MeaningOfLifeFinder()).execute();
        }
    }

    class MeaningOfLifeFinder extends SwingWorker<String, Object> {
        @Override
        public String doInBackground() {
            for (Integer i=0;i<=5000000;i++) {
                statusLabel.setText(String.valueOf(i));
            }
            return "Terminé";
        }

        @Override
        protected void done() {
            try {
                statusLabel.setText(get());
            } catch (Exception ignore) {
            }
        }
    }

}
