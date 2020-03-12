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


        // Split d'une chaîne avec séparateur '|'
        strToSplit = "Morgann|Moussier|34 bis rue Saint-Marc|45000|Orléans";
        System.out.println(strToSplit);
        String[] array2 = strToSplit.split("\\|");
        for (int i=0; i<array2.length; i++) {
            System.out.println(array2[i]);
        }
    }
}
