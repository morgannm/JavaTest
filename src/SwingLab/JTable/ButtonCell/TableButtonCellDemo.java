package SwingLab.JTable.ButtonCell;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TableButtonCellDemo extends JFrame implements ActionListener{
    private ArrayList<Client> listClient;
    private ArrayList<JButton> listEdit, listDelete;
    private JTextField txtKey;
    private JButton btnSearch;
    private JTable tblResult;

    public TableButtonCellDemo(){
        super("Search Client Demo");
        listClient = new ArrayList<Client>();
        listEdit = new ArrayList<JButton>();
        listDelete = new ArrayList<JButton>();

        JPanel pnMain = new JPanel();
        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));

        JPanel pn1 = new JPanel();
        pn1.setLayout(new BoxLayout(pn1,BoxLayout.X_AXIS));
        pn1.setSize(this.getSize().width-5, 20);
        pn1.add(new JLabel("Keyword: "));
        txtKey = new JTextField();
        pn1.add(txtKey);
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        pn1.add(btnSearch);
        pnMain.add(pn1);

        JPanel pn2 = new JPanel();
        pn2.setLayout(new BoxLayout(pn2,BoxLayout.Y_AXIS));
        tblResult = new JTable(new ClientTableModel());
        JScrollPane scrollPane= new  JScrollPane(tblResult);
        tblResult.setFillsViewportHeight(false);
        scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, 250));

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        tblResult.getColumn("Edit").setCellRenderer(buttonRenderer);
        tblResult.getColumn("Delete").setCellRenderer(buttonRenderer);
        tblResult.addMouseListener(new JTableButtonMouseListener(tblResult));
        pn2.add(scrollPane);
        pnMain.add(pn2);
        this.add(pnMain);
        pnMain.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnSearch)){
            btnSearchClick();
            return;
        }
        for(int i=0; i<listEdit.size(); i++)
            if(btnClicked.equals(listEdit.get(i))){
                btnEditClick(i);
                return;
            }
        for(int i=0; i<listDelete.size(); i++)
            if(btnClicked.equals(listDelete.get(i))){
                btnDeleteClick(i);
                return;
            }
    }

    /**
     * processing the event that the Search button is clicked
     */
    private void btnSearchClick(){
        if((txtKey.getText() == null)||(txtKey.getText().length() == 0))
            return;
        ClientDAO clientDAO = new ClientDAO();
        listClient = clientDAO.searchClient(txtKey.getText().trim());
        listEdit.clear();
        listDelete.clear();
        for(int i=0; i<listClient.size(); i++){
            JButton btn = new JButton("Edit");
            btn.addActionListener(this);
            listEdit.add(btn);
            btn = new JButton("Delete");
            btn.addActionListener(this);
            listDelete.add(btn);

        }
        ((DefaultTableModel)tblResult.getModel()).fireTableDataChanged();
    }

    /**
     * processing the event that the @index Edit button is clicked
     * @param index
     */
    private void btnEditClick(int index){

        (new EditClientFrm(this, listClient.get(index), index)).setVisible(true);
    }

    /**
     * enable to refresh the result table after update a client from @Update form
     * @index: the index of updated client in the list
     * @Client: the updated client
     */
    public void refreshResultAfterUpdate(int index, Client client){
        listClient.remove(index);
        listClient.add(index, client);
        ((DefaultTableModel)tblResult.getModel()).fireTableDataChanged();
    }

    /**
     * processing the event that the @index Delete button is clicked
     * @param index
     */
    private void btnDeleteClick(int index){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (this, "Would  you like to delete this client?", "Warning", dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            ClientDAO clientDAO = new ClientDAO();
            clientDAO.deleteClient(listClient.get(index).getId());
            listClient.remove(index);
            listEdit.remove(index);
            listDelete.remove(index);
        }
        ((DefaultTableModel)tblResult.getModel()).fireTableDataChanged();
    }

    class ClientTableModel extends DefaultTableModel {
        private String[] columnNames = {"Id", "Name", "Address", "Tel", "Email", "Note", "Edit", "Delete"};
        private final Class<?>[] columnTypes = new  Class<?>[] {Integer.class, String.class, String.class,  String.class,
                String.class, String.class, JButton.class,  JButton.class};

        @Override public int getColumnCount() {
            return columnNames.length;
        }

        @Override public int getRowCount() {
            return listClient.size();
        }

        @Override public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override public Class<?> getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }

        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
            /*Adding components*/
            switch (columnIndex) {
                case 0:
                    return listClient.get(rowIndex).getId();
                case 1:
                    return listClient.get(rowIndex).getName();
                case 2:
                    return listClient.get(rowIndex).getAddress();
                case 3:
                    return listClient.get(rowIndex).getTel();
                case 4:
                    return listClient.get(rowIndex).getEmail();
                case 5:
                    return listClient.get(rowIndex).getNote();
                case 6:
                    return listEdit.get(rowIndex);
                case 7:
                    return listDelete.get(rowIndex);
                default: return "Error";
            }
        }
    }

    class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
            int row    = e.getY()/table.getRowHeight(); //get the row of the button

            //*Checking the row or column is valid or not
            if (row < table.getRowCount() && row >= 0  && column < table.getColumnCount() && column >= 0)  {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {
                    //perform a click event
                    ((JButton)value).doClick();
                }
            }
        }
    }

    class JTableButtonRenderer implements TableCellRenderer {
        @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                                 boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            return button;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TableButtonCellDemo myFrame = new TableButtonCellDemo();
        myFrame.setSize(600,300);
        myFrame.setVisible(true);
        myFrame.setLocation(200,10);
    }
}