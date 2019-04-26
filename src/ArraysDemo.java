import java.util.*;

class ArraysDemo {
    public static void main(String[] args) {
        // Tri d'un tableau avec la méthode sort de la classe Arrays
        String names[] = { "Lauren", "Audrina", "Heidi", "Whitney",
            "Stephanie", "Spencer", "Lisa", "Brody", "Frankie",
            "Holly", "Jordan", "Brian", "Jason" };
        System.out.println("The original order:");
        for (int i = 0; i < names.length; i++) {
            System.out.print(i + ": " + names[i] + " ");
        }
        Arrays.sort(names);
        System.out.println("\nThe new order:");
        for (int i = 0; i < names.length; i++) {
            System.out.print(i + ": " + names[i] + " ");
        }
        System.out.println();
    }
}