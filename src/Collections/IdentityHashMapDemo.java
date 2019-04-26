package Collections;


import java.util.HashMap;
        import java.util.IdentityHashMap;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);

        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(i1, "toto");
        hm.put(i2, "titi");
        //Ici, vu que i1.equals(i2) == true
        //nous n'aurons qu'un seule entrée dans la collection
        System.out.println(hm);
        //Ces trois instructions renverront la même valeur
        System.out.println(hm.get(i1));
        System.out.println(hm.get(i2));
        System.out.println(hm.get(1));

        System.out.println("----------------------------------");
        System.out.println("Maintenant avec IdentityHashMap : ");
        System.out.println("----------------------------------");
        IdentityHashMap<Integer, String> ihm = new IdentityHashMap<>();
        ihm.put(i1, "toto");
        ihm.put(i2, "titi");
        //Ici, vu que i1 == i2 => false
        //nous aurons deux entrées dans la collection
        System.out.println(ihm);
        //Ces trois instructions seront différentes
        System.out.println(ihm.get(i1));
        System.out.println(ihm.get(i2));
        System.out.println(ihm.get(1));
    }
}