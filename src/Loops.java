class Loops {
    public static void main(String[] args) {
        // Boucle for
        System.out.println("Boucle for");
        for (int dex = 0; dex < 100; dex++) {
            if (dex % 12 == 0) {
                System.out.print("#: " + dex + " ");
            }
        }
        System.out.println("");
        
        // Boucle while
        System.out.println("Boucle while");
        int limit = 5;
        int count = 1;
        while (count < limit) {
            System.out.println("Pork is not a verb");
            count++;
        }
        
        // continue : passe à l'itération suivante
        // la boucle n'affichera pas "The index is 15"
        System.out.println("Continue");
        int index = 0;
        while (index <= 30) {
            index = index + 5;
            if (index == 15)
                continue;
            System.out.println("The index is " + index);
        }
 
        // break : n'affichera que les multiplications avec j = 0 ou 1
        System.out.println("boucle avec break");
        for (int i=0; i<5; i++) {
            for (int j=0; j<10; j++) {
                if (j == 2)
                    break;
                System.out.println(i + " x " + j + " = " + i*j);
            }
        }

        // break avec boucle nommée
        // le break sortira de la boucle principale i
        System.out.println("break avec boucle nommée");
        iloop:
        for (int i=0; i<5; i++) {
            for (int j=0; j<10; j++) {
                if (j == 2)
                    break iloop;
                System.out.println(i + " x " + j + " = " + i*j);
            }
        }
        
        // boucle avec plusieurs initialisations et plusieurs incrémentations
        System.out.println("boucle complexe");
        int i, j;
        for (i = 0, j = 0; i * j < 1000; i++, j += 2) {
            System.out.println(i + " * " + j + " = " + (i * j));
        }
    }
}