package Objects.Decorator.Voiture;

public class VoitureAvecClimatisation extends Option {
    public VoitureAvecClimatisation(Voiture originale) {
        super(originale, 1.0);
    }
}
