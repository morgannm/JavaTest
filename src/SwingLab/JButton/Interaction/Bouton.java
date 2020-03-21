package SwingLab.JButton.Interaction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class Bouton extends JButton implements MouseListener {
    private String name;
    private Image img;

    public Bouton(String str){
        super(str);
        this.name = str;
        try {
            img = ImageIO.read(new File("fondBouton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
        g2d.setPaint(gp);
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        g2d.setColor(Color.black);

        //Objet permettant de connaître les propriétés d'une police, dont la taille
        FontMetrics fm = g2d.getFontMetrics();
        //Hauteur de la police d'écriture
        int height = fm.getHeight();
        //Largeur totale de la chaîne passée en paramètre
        int width = fm.stringWidth(this.name);

        //On calcule alors la position du texte, et le tour est joué
        g2d.drawString(this.name, this.getWidth() / 2 - (width / 2), (this.getHeight() / 2) + (height / 4));
    }

    @Override
    public void mouseClicked(MouseEvent event) {

    }

    @Override
    public void mousePressed(MouseEvent event) {
        try {
            img = ImageIO.read(new File("fondBoutonClic.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth())){
            // On a relâché le bouton de la souris en étant sur le bouton => on remet la couleur utilisé pour le survol du bouton
            try {
                img = ImageIO.read(new File("fondBoutonHover.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            // On a relâché le bouton en n'étant plus au-dessus du bouton => on remet la couleur par défaut
            try {
                img = ImageIO.read(new File("fondBouton.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        try {
            img = ImageIO.read(new File("fondBoutonHover.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseExited(MouseEvent event) {
        try {
            img = ImageIO.read(new File("fondBouton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
