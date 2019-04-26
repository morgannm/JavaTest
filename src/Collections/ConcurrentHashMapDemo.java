package Collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        //On crée un objet et on y met une entrée
        ConcurrentMap<Integer, String> concurent = new ConcurrentHashMap<>();
        concurent.putIfAbsent(10, "toto");

        //On récupère la valeur
        String str = concurent.putIfAbsent(10, "titi");
        //Affiche toto car 10 est déjà présent
        System.out.println(str);

        System.out.println("Test de suppression de valeur");
        System.out.println("-----------------------------");
        //On tente de supprimer
        boolean bool = concurent.remove(10, "titi");
        //Et ça ne fonctionne pas
        System.out.println(bool);

        //Ici, ça fonctionnera
        bool = concurent.remove(10, "toto");
        System.out.println(bool);

        System.out.println("Test de replacement de valeur");
        System.out.println("-----------------------------");
        //On rajoute une entrée
        concurent.putIfAbsent(10, "tutu");
        //On tente le remplacement
        System.out.println(concurent.replace(20, "tata"));
        System.out.println(concurent.replace(10, "tata"));

        System.out.println(concurent.replace(10, "tutu", "tyty"));
        System.out.println(concurent.replace(10, "tata", "tyty"));

    }
}