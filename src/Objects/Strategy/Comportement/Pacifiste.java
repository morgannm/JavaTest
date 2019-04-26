package Objects.Strategy.Comportement;

/**
 * Created by morga on 16/07/2017.
 */
public class Pacifiste implements EspritCombatif {
    public void combat() {
        System.out.println("Je ne combats pas !");
    }
}
