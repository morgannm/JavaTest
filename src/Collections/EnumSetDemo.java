package Collections;
import java.util.EnumSet;

public class EnumSetDemo {
    public static void main(String[] args) {

        //On récupère une instance de cette classe
        //via une méthode statique
        EnumSet<Days> es = EnumSet.allOf(Days.class);
        System.out.println(es);

        //On crée une sous collection
        EnumSet<Days> es2 = es.range(Days.MARDI, Days.VENDREDI);
        System.out.println(es2);

        //On crée une sous collection en prenant les
        //éléments non présents dans le set es2
        EnumSet<Days> es3 = es.complementOf(es2);
        System.out.println(es3);
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
    }}

