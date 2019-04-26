package Objects.Decorator.Voiture;

/**
 * Created by morga on 23/07/2017.
 */
public class Test {
    public static void main(String[] args){
        Voiture astonMartin = new AstonMartin();
        System.out.println("AstonMartin : " + astonMartin.Prix());
        astonMartin = new VoitureAvecClimatisation(astonMartin);
        System.out.println("AstonMartin avec climatisation : " + astonMartin.Prix());
        astonMartin = new VoitureAvecParachute(astonMartin);
        System.out.println("AstonMartin avec climatisation et parachute : " + astonMartin.Prix());
        astonMartin = new VoitureAmphibie(astonMartin);
        System.out.println("AstonMartin amphibie avec climatisation et parachute : " + astonMartin.Prix());
    }
}
