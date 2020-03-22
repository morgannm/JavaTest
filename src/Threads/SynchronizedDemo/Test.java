package Threads.SynchronizedDemo;

public class Test {
    public static void main(String[] args) {
        CompteEnBanque cb = new CompteEnBanque();
        Thread t = new Thread(new RunImpl(cb, "Utilisateur 1"));
        Thread t2 = new Thread(new RunImpl(cb, "Utilisateur 2"));
        t.start();
        t2.start();
    }
}
