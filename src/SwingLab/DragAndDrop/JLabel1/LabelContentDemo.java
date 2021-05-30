package SwingLab.DragAndDrop.JLabel1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//CTRL + SHIFT + O pour générer les imports
public class LabelContentDemo extends JFrame {

    public LabelContentDemo(){
        setTitle("Drag'n Drop avec un JLabel !");
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(2,2));
        pan.setBackground(Color.white);

        JLabel srcLib = new JLabel("Source de drag : ", JLabel.RIGHT);
        JLabel src = new JLabel("Texte à déplacer !");

        //-------------------------------------------------------------------
        //On crée le nouvel objet pour activer le drag'n drop
        src.setTransferHandler(new TransferHandler("text"));

        //On spécifie au composant qu'il doit envoyer ses données via son objet TransferHandler
        src.addMouseListener(new MouseAdapter(){
            //On utilise cet événement pour que les actions soient visibles dès le clic de souris…
            //Nous aurions pu utiliser mouseReleased, mais, niveau IHM, nous n'aurions rien vu
            public void mousePressed(MouseEvent e){
                //On récupère le JComponent
                JComponent lab = (JComponent)e.getSource();
                //Du composant, on récupère l'objet de transfert : le nôtre
                TransferHandler handle = lab.getTransferHandler();
                //On lui ordonne d'amorcer la procédure de drag'n drop
                handle.exportAsDrag(lab, e, TransferHandler.COPY);
            }
        });
        //-------------------------------------------------------------------

        JLabel destLib = new JLabel("Destination de drag : ", JLabel.RIGHT);
        JTextField dest = new JTextField();
        //On active le comportement par défaut de ce composant
        dest.setDragEnabled(true);

        pan.add(srcLib);
        pan.add(src);
        pan.add(destLib);
        pan.add(dest);

        setContentPane(pan);
        setVisible(true);
    }

    public static void main(String[] args){
        new LabelContentDemo();
    }
}