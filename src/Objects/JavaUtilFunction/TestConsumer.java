package Objects.JavaUtilFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumer {
    public static void main(String[] args) {
        List<Personne> lPersonne = Arrays.asList(
                new Personne(10, "toto"),
                new Personne(20, "titi"),
                new Personne(30, "tata"),
                new Personne(40, "tutu")
        );
        for (int i = 0; i < lPersonne.size(); i++)
        {System.out.print(lPersonne.get(i).getNom() + " " + lPersonne.get(i).getAge() + ", "); }
        System.out.println();

        Consumer<Personne> consumer = (Personne p) -> p.setAge(p.getAge() + 13);
        for (Personne p : lPersonne) {
            consumer.accept(p); // ajoute 13 à l'âge de la personne
            System.out.print(p.getNom() + " " + p.getAge() + ", ");
        }
    }
}
