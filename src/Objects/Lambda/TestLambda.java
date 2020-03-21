package Objects.Lambda;

public class TestLambda {
    public static void main(String[] args) {
        // Redéfinition d'une interface fonctionnelle à l'aide d'une lamdba
        Dialoguer d = (s) -> System.out.println("Tu as dis : " + s);

        // Utilisation de la redéfinition
        d.parler("Bonjour");
    }
}
