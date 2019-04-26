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
    }

    // val1 est passé par valeur
    private static void Fonction1(Short val1) {
        val1++;
    }

    private static void Fonction2(Short[] array) {
        array[0]++;
    }
}
