package Objects.Strategy.Comportement;

public class AucunSoin implements Soin {
    public void soigne() {
        System.out.println("Je ne donne AUCUN soin !");
    }
}