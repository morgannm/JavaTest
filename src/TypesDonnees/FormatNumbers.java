package TypesDonnees;

public class FormatNumbers {
    public static void main(String[] args) {
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
