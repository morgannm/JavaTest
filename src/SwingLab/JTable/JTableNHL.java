package SwingLab.JTable;

import javax.swing.*;
import javax.swing.table.TableColumnModel;

public class JTableNHL extends JTable {
    static String[] columnNames = {"Nom",
            "Ville",
            "Conference",
            "Division",
            "Date création",
            "Arena",
            "Coupe Stanley"};

    static Object[][] data = {
            {"Golden Knights", "Las Vegas", "West", "Pacific", new Integer(2017), "T-Mobile Arena", new Boolean(false)},
            {"Rangers", "New York", "East", "Metropolitan", new Integer(1926), "Madison Square Garden", new Boolean(false)},
            {"Bruins", "Boston", "East", "Atlantic", new Integer(2018), "TD Garden", new Boolean(true)},
            {"Penguins", "Pittsburgh", "East", "Metropolitan", new Integer(2018), "PPG Paints Arena", new Boolean(false)},
            {"Lightning", "Tampa Bay", "East", "Atlantic", new Integer(2018), "Amalie Arena", new Boolean(false)},
            {"Capitals", "Washington", "East", "Metropolitan", new Integer(2018), "Capital One Arena", new Boolean(false)},
            {"Canucks", "Vancouver", "West", "Pacific", new Integer(1970), "Rogers Arena", new Boolean(false)},
            {"Red Wings", "Detroit", "East", "Atlantic", new Integer(1926), "Little Caesars Arena", new Boolean(true)},
            {"Flyers", "Philadelphie", "East", "Metropolitan", new Integer(2018), "Wells Fargo Center", new Boolean(true)},
            {"Ducks", "Anaheim", "West", "Pacific", new Integer(2018), "Honda Arena", new Boolean(false)},
            {"Kings", "Los Angeles", "West", "Pacific", new Integer(2018), "Staples Center", new Boolean(false)},
            {"Blackhawks", "Chicago", "West", "Central", new Integer(1926), "United Center", new Boolean(false)},
            {"Senators", "Ottawa", "East", "Atlantic", new Integer(1992), "Centre Canadian Tire", new Boolean(false)},
            {"Canadiens", "Montreal", "East", "Atlantic", new Integer(1917), "Centre Bell", new Boolean(true)}
    };

    public JTableNHL() {

        super(data, columnNames);

        TableColumnModel columnModel = this.getColumnModel();
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
        this.setRowHeight(25);
        // Largeur des colonnes ne s'adaptent pas automatiquement pour remplir toute la largeur => permet le scroll horizontal
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.setAutoCreateRowSorter(true);
    }
}
