package TypesDonnees;

/**
 * Created by morga on 07/07/2018.
 */
public class Arrondis {
    public static void main(String[] args) {
        // Arrondit à l'unité de paquetage supérieure
        Double qteInitiale = 1500.0;
        Double qteParPaquet = 500.0;
        Double qteArrondie = Math.round(qteInitiale/qteParPaquet)*qteParPaquet;
        System.out.println("Qté initiale : " + qteInitiale + " => Qté arrondie : " + qteArrondie);

        qteInitiale=1501.0;
        qteArrondie = (Math.ceil(qteInitiale/qteParPaquet))*qteParPaquet;
        System.out.println("Qté initiale : " + qteInitiale + " => Qté arrondie : " + qteArrondie);

        //
        float x1 = 90;
        float x2 = 59;
        int nb = (int) Math.floor(x1/x2);
        System.out.println("Math.floor(" + x1 + "/" + x2 + ") = " + nb);
    }
}
