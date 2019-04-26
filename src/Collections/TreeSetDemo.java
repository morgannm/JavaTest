package Collections;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by morga on 04/07/2017.
 * Source : https://openclassrooms.com/courses/java-et-les-collections/l-interface-set-e
 */

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Double> set = new TreeSet<Double>();
        set.add(12.52d);
        set.add(-5d);
        set.add(102.56d);
        set.add(75d);
        set.add(-52d);
        //Vous pouvez voir que, malgré l'insertion dans le désordre
        //L'affichage se fait dans l'ordre
        System.out.println(set);

        Double d = set.ceiling(12.52d);
        System.out.println(d); //Retourne bien 12.52

        d = set.higher(12.52d);
        System.out.println(d); //Retourne bien 75.0

        //on extrait une sous-section de notre objet
        NavigableSet<Double> nSet = set.subSet(12.52d, true, 75d, false);
        System.out.println(nSet);//Mais ne contient qu'un élément... ^^

        //On retire le plus petit élément
        set.pollFirst();
        System.out.println(set);

        //On retire le plus grand élément
        set.pollLast();
        System.out.println(set);
    }
}