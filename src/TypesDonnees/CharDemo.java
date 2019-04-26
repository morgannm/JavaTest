package TypesDonnees;

/**
 * Created by morga on 06/09/2017.
 */
public class CharDemo {
    public static void main(String[] args) {
        char c = 'A';
        System.out.println(c);
        while(c<'I') {
            c++;
            System.out.println(c);
        }

        // Boucle sur les lettres de l'alphabet
        System.out.println("Lettre de l'alphabet");
        for (char x='A';x<='Z';x++) {
            System.out.println(x);
        }
    }
}