package TypesDonnees;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormatNumbers {
    public static void main(String[] args) {
        String nombre = "169,23";
        NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
        try {
            float fNombre = nf.parse(nombre).floatValue();
            System.out.println("fNombre : " + String.format("%.2f",fNombre));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Double test1 = 1.234;
        Double test2 = 1000.0;
        Double result1 = test2/(test1*1000);

        System.out.println("Double sans formatage : " + result1);
        System.out.println("Double %f : " + String.format("%f",result1));

        Double test3 = 2.234;
        Double test4 = 1.0;
        Double result2 = test4/(test3*1000);
        System.out.println("Double sans formatage : " + result2);
        System.out.println("Double %.4f : " + String.format("%.4f",result2));

        float float1 = 5000;
        System.out.println("Float %.2f : " + String.format("%.2f",float1));

        // Formatage d'un entier complété à gauche avec des zéros
        System.out.println("Formatage d'un entier complété à gauche avec des zéros");
        for (int i=0;i<=10;i++) System.out.println(String.format("%03d",i));
    }
}
