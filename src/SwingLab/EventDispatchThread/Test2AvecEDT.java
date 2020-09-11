package SwingLab.EventDispatchThread;

import javax.swing.*;

public class Test2AvecEDT {
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
        //Le second thread
        new Thread(new Runnable(){
            public void run(){
                for(int i = 0; i < 5; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Modification de notre composant dans l'EDT
                    Thread t = new Thread(new Runnable(){
                        public void run(){
                            bouton.setText("Pause " + ++count);
                        }
                    });
                    if(SwingUtilities.isEventDispatchThread())
                        t.start();
                    else{
                        System.out.println("Lancement dans l' EDT");
                        SwingUtilities.invokeLater(t);
                    }
                }
            }
        }).start();
    }
}