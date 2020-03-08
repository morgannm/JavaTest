package Objects.Strategy;

import Objects.Strategy.Comportement.Operation;
import Objects.Strategy.Comportement.Soin;

class Test{
    public static void main(String[] args) {
        Personnage[] tPers = {new Guerrier(), new Civil(), new Medecin()};

        for(int i = 0; i < tPers.length; i++){
            System.out.println("\nInstance de " + tPers[i].getClass().getName());
            System.out.println("*****************************************");
            tPers[i].combattre();
            tPers[i].seDeplacer();
            tPers[i].soigner();
        }

        Personnage pers = new Guerrier();
        pers.soigner();
        // Modification du comportement à la volée
        pers.setSoin(new Operation());
        pers.soigner();

        // Utilisation d'une classe anonyme
        pers.setSoin(new Soin() {
            public void soigne() {System.out.println("Je soigne avec une classe anonyme");}
        });
        pers.soigner();
    }
}