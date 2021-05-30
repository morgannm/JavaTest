package Collections.Objects;

public class Modele {
    int largeur;
    int hauteur;
    int posX;
    int posY;

    public Modele(int largeur,int hauteur, int posX, int posY) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.posX = posX;
        this.posY = posY;
    }

    public String toString() {
        return largeur + " x " + hauteur + " - " + posX + "/" + posY;
    }
}
