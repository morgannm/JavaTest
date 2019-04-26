/**
 * Created by morgannm on 17/07/2017.
 */
public class EnumDemo {
    public static void main(String args[]){
        for(Langage lang : Langage.values()){
            if(Langage.JAVA.equals(lang))
                System.out.println("J'aime le : " + lang);
            else
                System.out.println(lang);
        }
    }

    public enum Langage {
        //Objets directement construits
        JAVA ("Langage JAVA"),
        C ("Langage C"),
        CPlus ("Langage C++"),
        PHP ("Langage PHP");

        private String name = "";

        //Constructeur
        Langage(String name){
            this.name = name;
        }

        public String toString(){
            return name;
        }
    }
}
