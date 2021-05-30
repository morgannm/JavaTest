package SwingLab.DragAndDrop.JLabel2;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

//CTRL + SHIFT + O pour générer les imports
public class MyTransferHandler extends TransferHandler {

    /**
     * Détermine le comportement du composant vis-à-vis du drag'n drop :
     * variables statiques COPY, MOVE, COPY_OR_MOVE, LINK ou NONE
     */
    public int getSourceActions(JComponent c) {
        return MOVE;
    }

    /**
     * Méthode permettant à l'objet de savoir si les données reçues
     * via un drop sont autorisées à être importées
     */
    public boolean canImport(TransferHandler.TransferSupport info) {
        //Nous contrôlons si les données reçues sont d'un type autorisé, ici String
        if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return false;
        }
        return true;
    }

    /**
     * C'est ici que l'insertion des données dans notre composant est réalisée
     */
    public boolean importData(TransferHandler.TransferSupport support){
        //Nous contrôlons si les données reçues sont d'un type autorisé
        if(!canImport(support))
            return false;

        //On récupère notre objet Transferable, celui qui contient les données en transit
        Transferable data = support.getTransferable();
        String str = "";

        try {
            //Nous récupérons nos données en spécifiant ce que nous attendons
            str = (String)data.getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Via le TRansferSupport, nous pouvons récupérer notre composant
        JLabel lab = (JLabel)support.getComponent();
        //Afin de lui affecter sa nouvelle valeur
        lab.setText(str);

        return true;
    }

    /**
     * Cette méthode est invoquée à la fin de l'action DROP
     * Si des actions sont à faire ensuite, c'est ici qu'il faudra coder le comportement désiré
     */
    protected void exportDone(JComponent c, Transferable t, int action){
        //Une fois le drop effectué nous effaçons le contenu de notre JLabel
        if(action == MOVE)
            ((JLabel)c).setText("");
    }

    /**
     * Dans cette méthode, nous allons créer l'objet utilisé par le système de drag'n drop
     * afin de faire circuler les données entre les composants
     * Vous pouvez voir qu'il s'agit d'un objet de type Transferable
     */
    protected Transferable createTransferable(JComponent c) {
        //On retourne un nouvel objet implémentant l'interface Transferable
        //StringSelection implémente cette interface,  nous l'utilisons donc
        return new StringSelection(((JLabel)c).getText());
    }

}