class Strings {
    public static void main(String[] args) {
        // caractère
        char quitKey = '@';
        
        // chaine de caractères
        String fullName = "Ada McGrath Stewart";
        
        // Affichage d'une chaine avec un retour à la ligne
        System.out.println("Silence affects everyone in the end");
        
        // Affichage sans retour à la ligne : print
        System.out.print("She never said ");
        System.out.println("another word.");
        
        // Double quote dans une chaine
        System.out.println("Jane Campion directed \"The Piano\" in 1993.");
        
        // Retour à la ligne dans une chaine
        System.out.println("Music by\nMichael Nyman");
        
        // Concaténation de chaines
        System.out.println("\"\'The Piano\' is as peculiar and haunting as any" + 
                " film I've seen.\"\n\t— Roger Ebert, Chicago Sun-Times");
        String searchKeywords = "";
        searchKeywords += "drama ";
        searchKeywords += "romance ";
        searchKeywords += "New Zealand";
        System.out.println(searchKeywords);
        
        // Concaténation de chaines et de nombres
        int length = 121;
        char rating = 'R';
        System.out.println("Running time: " + length + " minutes");
        System.out.println("Rated " + rating);
        
        // Comparaison de chaines
        String favorite = "piano";
        String guess = "ukulele";
        System.out.println("Is Ada's favorite instrument a " + guess + "?");
        System.out.println("Answer: " + favorite.equals(guess));
        
        // Longueur d'une chaine
        String cinematographer = "Stuart Dryburgh";
        int nameLength = cinematographer.length();
        
        // Changer la casse d'une chaine
        String baines = "Harvey Keitel";
        String change = baines.toUpperCase();
        System.out.println(change);
        
        // Position d'une sous-chaine
        String book = "Sams Teach Yourself in 24 Hours, 6th Edition";
        String search1 = "Teach";
        String search2 = "hours";
        int posFound = book.indexOf(search1);
        int posNotFound = book.indexOf(search2);
        System.out.println("Position de '" + search1 + "' dans '" + book + "' : " + posFound);
        System.out.println("Position de '" + search2 + "' dans '" + book + "' : " + posNotFound); // non trouvé = -1

        // Caractère à une position de la chaine
        char x = book.charAt(5);
        System.out.println("Caractère à la position 5 de '" + book + "' : " + x);

        // Sous-chaine d'une chaine
        String substring = book.substring(5,10);
        System.out.println("Sous-chaine de '" + book + "' de la position 5 à 10 (non inclus) : " + substring);
    }
}