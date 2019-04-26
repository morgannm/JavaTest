package Objects.Decorator.Patisserie.Couche;

import Objects.Decorator.Patisserie.Patisserie;

public class CoucheBiscuit extends Couche {
    public CoucheBiscuit(Patisserie p) {
        super(p);
        this.nom = "\t- Une couche de biscuit.\n";
    }
}