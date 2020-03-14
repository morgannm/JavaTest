package Objects.JavaUtilFunction;

import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String[] args) {
        Supplier<String> s1 = () -> new String("hello !");
        System.out.println(s1.get());

        // fonction qui retourne toujours le même objet
        Supplier<Personne> s2 = () -> new Personne(50, "Dédé");

        System.out.println(s2.get());
    }
}
