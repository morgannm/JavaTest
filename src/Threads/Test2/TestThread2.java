package Threads.Test2;

public class TestThread2 {
    public static void main(String[] args) {
        ThreadTest2 t = new ThreadTest2("A");
        ThreadTest2 t2 = new ThreadTest2("B", t);
        // Pour attendre que l'exécution des 2 threads soit terminée
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("statut du thread " + t.getName() + " = " + t.getState());
        System.out.println("statut du thread " + t2.getName() + " = " + t2.getState());
    }
}
