package Threads.ForkJoin2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// Calcul de la somme d'une suite de nombres
// Lorsque la taille d'une suite dépasse un certain seuil, elle est découpée en 2 tâches, qui sont elles aussi éventuellement découpées en 2 tâches
public class CalculSuite extends RecursiveTask<Long> {

    private long debut = 0, fin = 0, resultat;
    private int SEUIL = 1_000;

    public CalculSuite(long debut, long fin){
        this.debut = debut;
        this.fin = fin;
    }

    protected Long compute() {
        long nombreDeChoseAFaire = fin - debut;
        if(nombreDeChoseAFaire < SEUIL){
            // la taille de la suite est en dessous du seuil : on fait le calcul en une seule tâche
            System.out.println("Passage en mode MonoThread ou le découpage calcul le résultat");
            resultat = calculer();
        }
        else{
            // la taille de la suite est supérieure au seuil => on découpe la tâche en 2 pour l'exécuter dans 2 threads
            System.out.println("Passage en mode Fork/Join");
            //On découpe la tâche en deux
            // si la taille des sous-tâches est encore trop grande elles seront à nouveau découpées en 2
            long milieu = nombreDeChoseAFaire/2;
            CalculSuite calcul1 = new CalculSuite(debut, (debut+milieu)-1);
            calcul1.fork();

            CalculSuite calcul2 = new CalculSuite(debut + milieu, fin);

            // récupère le résultat des 2 threads
            resultat = calcul2.compute() + calcul1.join();
        }
        return resultat;
    }

    public long calculer(){

        for(long i = debut; i <= fin; i++){
            System.out.println(resultat + " + " + i);
            resultat += i;
        }
        return resultat;
    }

    public long getResultat(){  return resultat;  }

    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool();
        CalculSuite calcul = new CalculSuite(0, 100_000);
        pool.invoke(calcul);
        System.out.println("Résultat du calcul : " + calcul.getResultat());
    }
}