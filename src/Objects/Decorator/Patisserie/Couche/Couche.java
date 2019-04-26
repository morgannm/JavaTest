package Objects.Decorator.Patisserie.Couche;

import Objects.Decorator.Patisserie.Patisserie;

public abstract class Couche extends Patisserie {
    protected Patisserie pat;
    protected String nom;

    public Couche(Patisserie p){
        pat = p;
    }

    public String preparer() {
        String str = pat.preparer();
        return str + nom;
    }
}
