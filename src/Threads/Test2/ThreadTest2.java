package Threads.Test2;

public class ThreadTest2 extends Thread {
    Thread t; // pour observer l'état d'un autre thread depuis celui-ci

    public ThreadTest2(String name) {
        super(name);
        System.out.println("statut du thread " + name + " = " + this.getState());
        this.start();
        System.out.println("statut du thread " + name + " = " + this.getState());
    }

    // constructeur dans lequel on peut passer un autre Thread pour observer son état
    public ThreadTest2(String name, Thread t) {
        super(name);
        this.t = t;
        System.out.println("statut du thread " + name + " = " + this.getState());
        this.start();
        System.out.println("statut du thread " + name + " = " + this.getState());
    }

    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println("statut du thread " + this.getName() + " = " + this.getState());
            if (t != null)
                System.out.println("statut de " + t.getName() + " pendant le thread " + this.getName() + " = " + t.getState());
            try {
                // Suspend l'exécution du thread, ce qui permet de voir un autre thread s'exécuter en parallèle
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setThread(Thread t) {
        this.t = t;
    }
}
