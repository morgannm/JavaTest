package Objects.Decorator.Voiture;

public class AstonMartin extends Voiture {
    public AstonMartin() {
        this.prix = 999.99;
    }

    @Override
    public double Prix() {
        return this.prix;
    }
}
