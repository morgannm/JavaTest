
package SwingLab.JTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TableDemoCellRenderer extends JPanel {
    private boolean DEBUG = false;

    public TableDemoCellRenderer() {
        super(new GridLayout(1,0));


        JTable table = new JTable(new MyTableModel());

        // Centre les données des colonnes qui affichent des chaînes de caractères
        DefaultTableCellRenderer dtcr = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
        dtcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        table.getColumnModel().getColumn(2).setCellRenderer(new IntegerFormatRenderer());
        table.getColumnModel().getColumn(3).setCellRenderer(new IntegerFormatRenderer());
        table.getColumnModel().getColumn(4).setCellRenderer(new FloatFormatRenderer(2));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    // POur afficher un nombre sous la forme d'un entier
    class IntegerFormatRenderer extends DefaultTableCellRenderer {

        public IntegerFormatRenderer() {
            setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            if (value instanceof Number) {
                NumberFormat numberFormat = NumberFormat.getNumberInstance();
                numberFormat.setMaximumFractionDigits(0); // pas de décimales
                value = numberFormat.format(value);
            }

            return super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column );
        }
    }

    class FloatFormatRenderer extends DefaultTableCellRenderer {
        final  NumberFormat numberFormat = NumberFormat.getNumberInstance();

        public FloatFormatRenderer(int nbDecimales) {
            setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
            numberFormat.setMaximumFractionDigits(nbDecimales); // pas de décimales
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            if (value instanceof Float) {
                value = numberFormat.format(value);
            }

            return super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column );
        }
    }

    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Pays",
                "Continent",
                "Population",
                "Surface",
                "Densité",
                "Capitale"};
        private Object[][] data = {
                {"France", "Europe", new Integer(65000000), new Float(551500.0), new Float(118.94599914),"Paris"},
                {"Allemagne", "Europe", new Integer(83516000), new Float(357376.00708), new Float(239.605895996094),"Berlin"},
                {"Afghanistan", "Asie", new Integer(38041801), new Float(652864.0136), new Float(58.269401550293),"Kabul"},
                {"Australie", "Océanie", new Integer(25203199), new Float(7692060.05859375), new Float(3.280699968),"Camberra"},
                {"Canada", "Amérique du Nord", new Integer(37410999), new Float(9984669.21875), new Float(4.1139998435),"Ottawa"},
                {"Côte d'Ivoire", "Afrique", new Integer(25716499), new Float(322463.01269), new Float(80.8695983886719),"Yamoussoukro"},
                {"Equateur", "Amérique du Sud", new Integer(17373699), new Float(257217.010498047), new Float(69.953498840332),"Quito"},
        };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer editor for each cell.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }

         */

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TableDemo");
        frame.setTitle("JTable : Formatage des données affichées");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //Create and set up the content pane.
        TableDemoCellRenderer newContentPane = new TableDemoCellRenderer();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        //frame.pack();
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
