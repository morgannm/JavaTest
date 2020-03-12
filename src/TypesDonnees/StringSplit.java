package TypesDonnees;

public class StringSplit {
    public static void main(String[] args) {
        // Split d'une chaîne avec séparateur Tabulation
        String strToSplit = "Morgann\tMoussier\t34 bis rue Saint-Marc\t45000\tOrléans";
        System.out.println(strToSplit);
        String[] array = strToSplit.split("\t");
        for (int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
