package Objects.Decorator.Patisserie.Couche;

import Objects.Decorator.Patisserie.Patisserie;

public class CoucheCaramel extends Couche{
    public CoucheCaramel(Patisserie p) {
        super(p);
        this.nom = "\t- Une couche de caramel.\n";
    }
}
