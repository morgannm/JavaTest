package Threads.SynchronizedDemo;

public class CompteEnBanque {
    private int solde = 100;

    public int getSolde() {
        if (this.solde < 0)
            System.out.println("Vous êtes à découvert!");
        return this.solde;
    }

    // Le mot-clé synchronized empêche d'autres threads d'accéder à cette méthode si elle est en cours d'utilisation
    public synchronized void retraitArgent(int retrait) {
        solde = solde - retrait;
        System.out.println("Solde = " + solde);
    }
}
