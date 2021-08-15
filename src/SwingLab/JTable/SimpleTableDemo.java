/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package SwingLab.JTable;

/*
 * SimpleTableDemo.java requires no other files.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimpleTableDemo extends JPanel {
    private boolean DEBUG = false;

    public SimpleTableDemo() {
        super(new GridLayout(1,0));

        String[] columnNames = {"Nom",
                                "Ville",
                                "Conference",
                                "Division",
                                "Date création",
                                "Arena",
                                "Coupe Stanley"};

        Object[][] data = {
    	    {"Golden Knights", "Las Vegas", "West", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)},
            {"Rangers", "New York", "East", "Pacific", new Integer(1926), "Madison Square Garden", new Boolean(false)},
            {"Bruins", "Boston", "East", "Atlantic", new Integer(2018), "T-Mobile Arena", new Boolean(true)},
            {"Penguins", "Pittsburgh", "East", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)},
            {"Lightning", "Tampa Bay", "West", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)},
            {"Capitals", "Washington", "East", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)},
            {"Canucks", "Vancouver", "West", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)},
            {"Red Wings", "Detroit", "West", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)},
            {"Flyers", "Philadelphie", "West", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)},
            {"Ducks", "Anaheim", "West", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)},
            {"Kings", "Los Angeles", "West", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)},
            {"Blackhawks", "Chicago", "West", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)},
            {"Senators", "Ottawa", "West", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)},
            {"Canadiens", "Montreal", "West", "Pacific", new Integer(2018), "T-Mobile Arena", new Boolean(false)}
        };

        final JTable table = new JTable(data, columnNames);

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(100);

        /*
        table.setPreferredScrollableViewportSize(new Dimension(700, 400));
        table.setFillsViewportHeight(true);
        */

        // Largeur des colonnes ne s'adaptent pas automatiquement pour remplir toute la largeur => permet le scroll horizontal
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        // Barres de scroll horizontales et verticales
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        SimpleTableDemo newContentPane = new SimpleTableDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setSize(1000,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
