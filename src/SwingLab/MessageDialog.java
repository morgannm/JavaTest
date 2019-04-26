package SwingLab;

import javax.swing.*;

/**
 * Created by morgannm on 27/02/2016.
 */
public class MessageDialog {
    public static void main(String[] args)
    {
        JLabel label = new JLabel("Label test");
        JOptionPane pane = new JOptionPane();
        pane.showMessageDialog(null, label);
    }
}
