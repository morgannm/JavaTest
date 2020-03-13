package SwingLab.JTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TableDoubleClickDemo extends JFrame {
    public TableDoubleClickDemo() {
        super("Table example, Wines from Bordeaux");

        final Object[][] tabledata = {
                { "Chateau Meyney, St. Estephe",       new Integer(1994), "$18.75"},
                { "Chateau Montrose, St. Estephe",     new Integer(1975), "$54.25" },
                { "Chateau Gloria, St. Julien",        new Integer(1993), "$22.99" },
                { "Chateau Beychevelle, St. Julien",   new Integer(1970), "$61.63" },
                { "Chateau La Tour de Mons, Margeaux", new Integer(1975), "$57.03" },
                { "Chateau Brane-Cantenac, Margeaux",  new Integer(1978), "$49.92" },
        };

        String columnheaders[] = { "Wine", "Vintage", "Price" };

        JTable table = new JTable(tabledata, columnheaders) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        pack();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    StringBuffer sb = new StringBuffer();
                    String lineSeparator = System.getProperty("line.separator");
                    sb.append(tabledata[row][0] + lineSeparator);
                    sb.append(tabledata[row][1] + lineSeparator);
                    sb.append(tabledata[row][2] + lineSeparator);
                    TextFrame textFrame = new TextFrame(sb.toString());
                    textFrame.setVisible(true);
                }
            }
        });
    }

    public static void main(String []args) {
        TableDoubleClickDemo main = new TableDoubleClickDemo();
        main.show();
    }
}

class TextFrame extends JFrame
{
    public TextFrame(String content) {
        super("TextFrame");

        JTextArea ta = new JTextArea();
        ta.setText(content);
        getContentPane().add(ta);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setSize(200, 100);
    }
}
