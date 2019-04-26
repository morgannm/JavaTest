package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        //DemoOpenClassRooms();
        DemoReverse();
    }

    private static void DemoReverse() {
        System.out.println("DemoReverse =========================================");
        List<Short> typesCahiers = new ArrayList<Short>();
        typesCahiers.add((short)4);
        typesCahiers.add((short)6);
        typesCahiers.add((short)8);
        typesCahiers.add((short)10);
        typesCahiers.add((short)12);
        typesCahiers.add((short)14);
        typesCahiers.add((short)16);
        typesCahiers.add((short)18);
        typesCahiers.add((short)20);
        typesCahiers.add((short)24);
        typesCahiers.add((short)28);
        typesCahiers.add((short)30);
        typesCahiers.add((short)32);
        typesCahiers.add((short)36);
        typesCahiers.add((short)40);
        typesCahiers.add((short)48);
        typesCahiers.add((short)64);
        typesCahiers.add((short)96);

        System.out.println("Liste dans l'ordre d'origine");
        for(short typeCahier:typesCahiers) {
            System.out.println(typeCahier);
        }
        System.out.println("Liste dans l'ordre inversé");
        Collections.reverse(typesCahiers);
        for(short typeCahier:typesCahiers) {
            System.out.println(typeCahier);
        }
    }

    private static void DemoOpenClassRooms() {
        System.out.println("DemoOpenClassRooms =========================================");
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        //On met la liste dans le désordre
        Collections.shuffle(list);
        System.out.println(list);

        //On la remet dans l'ordre
        Collections.sort(list);
        System.out.println(list);

        Collections.rotate(list, -1);
        System.out.println(list);

        //On récupère une sous-liste
        List<String> sub = list.subList(2, 5);
        System.out.println(sub);
        Collections.reverse(sub);
        System.out.println(sub);

        //On récupère un ListIterator
        ListIterator<String> it = list.listIterator();
        while(it.hasNext()){
            String str = it.next();
            if(str.equals("d"))
                it.set("z");
        }
        while(it.hasPrevious())
            System.out.print(it.previous());

    }
}