package Objects.Decorator.Voiture;

public class Option extends Voiture {
    protected Voiture _originale;
    protected double _tarifOption;

    public Option(Voiture originale, double tarif) {
        _originale = originale;
        _tarifOption = tarif;
    }

    @Override
    public double Prix() {
        return _originale.Prix() + _tarifOption;
    }
}
