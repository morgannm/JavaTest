package SwingLab.EventDispatchThread;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//CTRL + SHIFT + O pour générer les imports
public class SwingWorkerDemo {
    static int count = 0;
    static JButton bouton = new JButton("Pause");
    public static void main(String[] args){

        JFrame fen = new JFrame("EDT");
        fen.getContentPane().add(bouton);
        fen.setSize(200, 100);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setLocationRelativeTo(null);
        fen.setVisible(true);
        updateBouton();

        System.out.println("Reprise du thread principal");
    }

    public static void updateBouton(){
        SwingWorker sw = new SwingWorker(){
            protected Object doInBackground() throws Exception {
                for(int i = 0; i < 5; i++){
                    try {
                        //On change la propriété d'état
                        setProgress(i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            public void done(){
                if(SwingUtilities.isEventDispatchThread())
                    System.out.println("Ce thread est dans l'EDT ! ");
                bouton.setText("Traitement terminé");
            }
        };
        //On écoute le changement de valeur pour la propriété
        sw.addPropertyChangeListener(new PropertyChangeListener(){
            //Méthode de l'interface
            public void propertyChange(PropertyChangeEvent event) {
                //On vérifie tout de même le nom de la propriété
                if("progress".equals(event.getPropertyName())){
                    if(SwingUtilities.isEventDispatchThread())
                        System.out.println("Dans le listener donc dans l'EDT ! ");
                    //On récupère sa nouvelle valeur
                    bouton.setText("Pause " + (Integer) event.getNewValue());
                }
            }
        });
        //On lance le SwingWorker
        sw.execute();
    }
}