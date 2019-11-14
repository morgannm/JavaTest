import java.util.ArrayList;
import java.util.List;

/**
 * Created by morga on 28/12/2016.
 */
public class Parameters {
    public static void main(String[] args)
    {
        Short test1=0;
        Fonction1(test1); // au retour test1 = 0 car passé par valeur
        System.out.println("Retour de Fonction1 => test1 = " + test1);

        Short[] test2 = {0};
        Fonction2(test2); // au retour test1 = 0 car passé par valeur
        System.out.println("Retour de Fonction2 => test2 = " + test2[0]);

        List<Integer> list = new ArrayList<>();
        CompleteList(list); // au retour la liste contient les éléments ajoutés
        System.out.println("Retour de CompleteList => list.size() = " + list.size());

        String str = "";
        FonctionString(str); // au retour str est vide car passé par valeur
        System.out.println("Retour de FonctionString => str = " + str);
    }

    // val1 est passé par valeur
    private static void Fonction1(Short val1) {
        val1++;
    }

    private static void Fonction2(Short[] array) {
        array[0]++;
    }

    private static void FonctionString(String str) {
        str = "FonctionString";
    }

    private static void CompleteList(List<Integer> list) {
        list.add(1);
        list.add(2);
    }
}
