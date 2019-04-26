package Objects.Decorator.Voiture;

public class VoitureAvecParachute extends Option {
    public VoitureAvecParachute(Voiture originale) {
        super(originale, 10.0);
    }
}
