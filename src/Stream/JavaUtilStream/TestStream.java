package Stream.JavaUtilStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        List<Personne> listP = Arrays.asList(
                new Personne(1.80, 70, "A", "Nicolas", Couleur.BLEU),
                new Personne(1.56, 50, "B", "Nicole", Couleur.VERRON),
                new Personne(1.75, 65, "C", "Germain", Couleur.VERT),
                new Personne(1.68, 50, "D", "Michel", Couleur.ROUGE),
                new Personne(1.96, 65, "E", "Cyrille", Couleur.BLEU),
                new Personne(2.10, 120, "F", "Denis", Couleur.ROUGE),
                new Personne(1.90, 90, "G", "Olivier", Couleur.VERRON)
        );

        // Parcourir une collection à l'aide d'un stream
        Stream<Personne> sp = listP.stream();
        sp.forEach(System.out::println); // utilisation d'une référence de méthode
        //sp.forEach(System.out::println); // erreur si on essaye d'utiliser le stream une 2ème fois

        // Récupérer le 1er objet en fonction du filtre
        sp = listP.stream();
        Optional<Personne> pers = sp.filter(x -> x.getPoids() > 50).findFirst();
        System.out.println(pers.toString());

        // Méthode filter
        System.out.println();
        System.out.println("Filtre sur le poids > 50");
        sp = listP.stream();
        sp.filter(x -> x.getPoids() > 50)
                .forEach(System.out::println);

        // Méthode filter : compter le nbre d'éléments en fonction de la valeur d'une propriété
        System.out.println();
        sp = listP.stream();
        long nb = sp.filter(x -> x.getPoids() > 65).count();
        System.out.println("Compter les éléments dont le poids > 65 : " + nb);

        // Méthode map : pour ne récupérer que certaines données
        System.out.println();
        System.out.println("Méthode map : pour ne récupérer que certaines données");
        sp = listP.stream();
        sp.filter(x -> x.getPoids() > 50)
                .map(x -> x.getPoids())
                .forEach(System.out::println);

        // Méthode terminale reduce => fait une somme
        System.out.println();
        System.out.println("Méthode terminale reduce => fait la somme des poids ");
        sp = listP.stream();
        Double sum = sp.filter(x -> x.getPoids() > 50)
                .map(x -> x.getPoids())
                .reduce(0.0d, (x,y) -> x+y);
        System.out.println(sum);

        // Objet Optional avec un filtre ne retournant aucune valeur => génère une exception si pas géré
        System.out.println();
        System.out.println("Objet Optional avec un filtre ne retournant aucune valeur => génère une exception");
        sp = listP.stream();
        Optional<Double> sumopt = sp.filter(x -> x.getPoids() > 250)
                .map(x -> x.getPoids())
                .reduce((x, y) -> x + y);
        // si on n'utilise pas orElse ou isPresent, on obtient une exception car sumopt est null (le filtre ne renvoie aucune valeur)
        System.out.println(sumopt.orElse(0.0));
        if (sumopt.isPresent())
            System.out.println(sumopt.get());
        else
            System.out.println("Aucun agrégat de poids");

        // Méthode count
        System.out.println();
        System.out.println("Méthode terminale count => compte le nombre d'éléments après le filtre");
        sp = listP.stream();
        long count = sp.filter(x -> x.getPoids() > 50)
                .map(x -> x.getPoids())
                .count();
        System.out.println("Nombre d'éléments : " + count);

        // Méthode collect : récupère le résultat sous différentes formes
        System.out.println();
        System.out.println("Méthode collect renvoyant une liste des éléments filtrés");
        sp = listP.stream();
        List<Double> ld = sp.filter(x -> x.getPoids() > 50)
                .map(x -> x.getPoids())
                .collect(Collectors.toList());
        System.out.println(ld);

        // Lecture d'un fichier avec un stream
        System.out.println();
        System.out.println("Lecture d'un fichier avec un stream");
        String fileName = "JavaTest.iml";
        try(Stream<String> sf = Files.lines(Paths.get(fileName))){
            sf.forEach(System.out::println);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
