package Objects.Strategy;

import Objects.Strategy.Comportement.*;

public class Civil extends Personnage{
    public Civil() {}

    public Civil(EspritCombatif esprit, Soin soin, Deplacement dep) {
        super(esprit, soin, dep);
    }
}