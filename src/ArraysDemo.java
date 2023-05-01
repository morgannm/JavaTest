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

        // Tableau d'objets
        Player[] players = new Player[5];
        players[0] = new Player("Connor","Mc David");
        players[1] = new Player("David","Pastrnak");
        players[2] = new Player("Auston","Matthews");
        players[3] = new Player("Cale","Makar");
        players[4] = new Player("Artemi","Panarin");
        for (int i=0; i<=4;i++) System.out.println(players[i].toString());
    }

    private static class Player {
        private String firstName;
        private String lastName;

        public Player(String firstName, String lastName) {
            this.firstName=firstName;
            this.lastName=lastName;
        }

        @Override
        public String toString() {
            return this.firstName + " " + this.lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}