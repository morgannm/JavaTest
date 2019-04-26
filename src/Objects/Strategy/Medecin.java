package Objects.Strategy;

import Objects.Strategy.Comportement.*;

public class Medecin extends Personnage{
    public Medecin() {
        this.soin = new PremierSoin();
    }
    public Medecin(EspritCombatif esprit, Soin soin, Deplacement dep) {
        super(esprit, soin, dep);
    }
}