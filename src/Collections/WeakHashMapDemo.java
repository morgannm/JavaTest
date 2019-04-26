package Collections;

import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void main(String[] args) {

        WeakHashMap<MyKey, String> whm = new WeakHashMap<>();
        MyKey key1 = new MyKey(1), key2 = new MyKey(2), key3 = new MyKey(3);
        whm.put(key1, "Valeur de toto");
        whm.put(key2, "Valeur de titi");
        whm.put(key3, "Valeur de tutu");

        //On affiche la collection
        System.out.println(whm);

        key1 = null;
        //On force le passage du ramasse-miettes
        //ce qui va détruire l'objet en mémoire
        //et donc dans la collection
        System.gc();
        System.out.println("\nAprès la destruction de la clé 1 par le ramasse-miettes : ");
        System.out.println(whm);

        key3 = null;
        System.gc();
        System.out.println("\nAprès la destruction de la clé 3 par le ramasse-miettes : ");
        System.out.println(whm);
    }
}

/**
 * Cette objet sert uniquement comme exemple
 * Il contient un simple entier
 */
class MyKey{
    private int key = 0;
    public MyKey(int key){
        this.key = key;
    }
    public String toString(){
        return "[MyKey:" + key + "]";
    }
}