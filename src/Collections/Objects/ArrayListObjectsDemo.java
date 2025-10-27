package Collections.Objects;

//import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListObjectsDemo {
    private static  ArrayList<Modele> modeles = new ArrayList<>();

    public static void main(String[] args) {
        modeles.add(new Modele(210,297,-1,-1));
        modeles.add(new Modele(210,297,-1,-1));
        modeles.add(new Modele(297,420,-1,-1));
        modeles.add(new Modele(148,210,-1,-1));
        modeles.add(new Modele(210,297,-1,-1));
        modeles.add(new Modele(180,240,-1,-1));
        modeles.add(new Modele(420,594,-1,-1));
        modeles.add(new Modele(210,297,-1,-1));
        //modeles.add(new Modele(210,297,-1,-1));
        //modeles.add(new Modele(210,297,-1,-1));
        //modeles.add(new Modele(210,297,-1,-1));
        displayModeles();

        modeles.sort(new Comparator<Modele>() {
            @Override
            public int compare(Modele o1, Modele o2) {
                if (o2.largeur<o1.largeur)
                    return -1;
                else if (o1.largeur>o2.largeur)
                    return 1;
                else
                    return 0;
            }
        });
        displayModeles();
    }

    private static void displayModeles() {
        System.out.println("------------------------------------------");
        for (Modele modele : modeles) {
            System.out.println(modele.toString());
        }
    }
}
