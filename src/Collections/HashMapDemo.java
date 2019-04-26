package Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// Source : https://openclassrooms.com/courses/java-et-les-collections/l-interface-map-k-v

public class HashMapDemo {
    public static void main(String[] args) {

        //La fameuse syntaxe en diamant de Java 7
        Map<Integer, String> hm = new HashMap<>();
        hm.put(10, "1");
        hm.put(20, "2");
        hm.put(30, "3");
        hm.put(40, "4");
        hm.put(50, "5");
        //Ceci va écraser la valeur 5
        hm.put(50, "6");

        System.out.println("Parcours de l'objet HashMap : ");
        Set<Entry<Integer, String>> setHm = hm.entrySet();
        Iterator<Entry<Integer, String>> it = setHm.iterator();
        while(it.hasNext()){
            Entry<Integer, String> e = it.next();
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        System.out.println("Valeur pour la clé 8 : " + hm.get(8));

        Map<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(10, "1");
        lhm.put(20, "2");
        lhm.put(30, "3");
        lhm.put(40, "4");
        lhm.put(50, "5");

        System.out.println("Parcours de l'objet LinkedHashMap : ");
        Set<Entry<Integer, String>> setLhm = lhm.entrySet();
        Iterator<Entry<Integer, String>> it2 = setLhm.iterator();
        while(it2.hasNext()){
            Entry<Integer, String> e = it2.next();
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}