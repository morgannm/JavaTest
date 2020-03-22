package Threads.Test1;

public class ThreadTest1 extends Thread {
    public ThreadTest1(String name) {
        super(name);
    }
    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println(this.getName());
            try {
                // Suspend l'exécution du thread, ce qui permet de voir un autre thread s'exécuter en parallèle
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
