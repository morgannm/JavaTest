package SwingLab.JTable.ButtonCell;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditClientFrm extends JFrame implements ActionListener{
    private TableButtonCellDemo parent;
    private Client client;
    private int index;
    private JTextField txtId, txtName, txtAddress, txtTel, txtEmail, txtNote;
    private JButton btnUpdate, btnReset;


    public EditClientFrm(TableButtonCellDemo parent, Client client, int index){
        super("Edit a client");
        this.parent = parent;
        this.client = client;
        this.index = index;

        txtId = new JTextField(15);
        txtId.setEditable(false);
        txtName = new JTextField(15);
        txtAddress = new JTextField(15);
        txtTel = new JTextField(15);
        txtEmail = new JTextField(15);
        txtNote = new JTextField(15);
        btnUpdate = new JButton("Update");
        btnReset = new JButton("Reset");

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(7,2));
        content.add(new JLabel("ID:"));     content.add(txtId);
        content.add(new JLabel("Name:"));     content.add(txtName);
        content.add(new JLabel("Address:"));     content.add(txtAddress);
        content.add(new JLabel("Tel:"));     content.add(txtTel);
        content.add(new JLabel("Email:"));     content.add(txtEmail);
        content.add(new JLabel("Note:"));     content.add(txtNote);
        content.add(btnUpdate);     content.add(btnReset);

        btnUpdate.addActionListener(this);
        btnReset.addActionListener(this);

        initForm();

        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initForm(){
        if(client != null){
            txtId.setText(client.getId()+"");
            txtName.setText(client.getName());
            txtAddress.setText(client.getAddress());
            txtTel.setText(client.getTel());
            txtEmail.setText(client.getEmail());
            txtNote.setText(client.getNote());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnReset)){
            initForm();
            return;
        }
        if(btnClicked.equals(btnUpdate)){
            btnUpdateClick();
        }
    }

    private void btnUpdateClick(){
        client.setName(txtName.getText());
        client.setAddress(txtAddress.getText());
        client.setTel(txtTel.getText());
        client.setEmail(txtEmail.getText());
        client.setNote(txtNote.getText());

        ClientDAO clientDAO = new ClientDAO();
        clientDAO.editClient(client);
        parent.refreshResultAfterUpdate(index, client);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}