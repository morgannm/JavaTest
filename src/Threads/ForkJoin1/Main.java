package Threads.ForkJoin1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        Path chemin = Paths.get("C:\\Users\\morga\\Documents");
        String filtre = "*.pdf";

        // Code mono-thread =======================================================================
        /*
        FolderScanner fs = new FolderScanner(chemin, filtre);
        try {
            Long start = System.currentTimeMillis();
            Long resultat = fs.sequentialScan();
            Long end = System.currentTimeMillis();
            System.out.println("Il y a " + resultat + " fichier(s) portant l'extension " + filtre);
            System.out.println("Temps de traitement : " + (end - start));
        } catch (ScanException e) {
            e.printStackTrace();
        }
        */

        // Code multi-thread ======================================================================
        // Tâche principale qui se charge du découpage en sous-tâches
        FolderScanner fs = new FolderScanner(chemin, filtre);

        //Nous récupérons le nombre de processeurs disponibles
        int processeurs = Runtime.getRuntime().availableProcessors();

        //Nous créons notre pool de thread pour nos tâches de fond
        ForkJoinPool pool = new ForkJoinPool(processeurs);
        Long start = System.currentTimeMillis();

        //Nous lançons le traitement de notre tâche principale via le pool
        pool.invoke(fs);

        Long end = System.currentTimeMillis();
        System.out.println("Il y a " + fs.getResultat() + " fichier(s) portant l'extension " + filtre);
        System.out.println("Temps de traitement : " + (end - start));
    }

}
