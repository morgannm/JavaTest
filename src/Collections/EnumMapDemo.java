package Collections;

import java.util.EnumMap;

public class EnumMapDemo {

    public static void main(String[] args) {
        EnumMap<Days, String> em = new EnumMap<>(Days.class);
        em.put(Days.LUNDI, null);
        em.put(Days.MARDI, "Métro");
        em.put(Days.MERCREDI, "Boulot");
        em.put(Days.JEUDI, "Dodo");
        em.put(Days.VENDREDI, "Boulot et apéro !");
        em.put(Days.SAMEDI, "Dodo et apéro !");
        em.put(Days.DIMANCHE, "apéro ! apéro ! apéro !");

        //affichage
        System.out.println(em);

        //Parcours de la collection
        for(Days d : Days.values())
            System.out.println(em.get(d));
    }

    public enum Days {
        LUNDI("Lundi"), MARDI("Mardi"), MERCREDI("Mercredi"),
        JEUDI("Jeudi"), VENDREDI("Vendredi"), SAMEDI("Samedi"),
        DIMANCHE("Dimanche");
        private String name;
        Days(String name){
            this.name = name;
        }
        public String toString(){
            return name;
        }
    }
}
