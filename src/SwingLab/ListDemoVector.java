package SwingLab;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by Morgann on 02/07/2016.
 */
public class ListDemoVector extends JFrame {
    public ListDemoVector() {
        super("ListDemoVector");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Vector months = new Vector();
        JList list = new JList(months);

        months.addElement("January");
        months.addElement("February");
        months.addElement("March");
        months.addElement("April");

        add(new JScrollPane(list));

        setVisible(true);
    }

    public static void main(String[] args) {
        ListDemoVector demo = new ListDemoVector();
    }
}
