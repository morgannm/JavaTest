package Objects.Strategy;

import Objects.Strategy.Comportement.*;

public class Guerrier extends Personnage {
    public Guerrier(){
        this.espritCombatif = new CombatPistolet();
    }
    public Guerrier(EspritCombatif esprit, Soin soin, Deplacement dep) {
        super(esprit, soin, dep);
    }
}