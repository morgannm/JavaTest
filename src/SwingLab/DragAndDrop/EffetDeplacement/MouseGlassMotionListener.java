package SwingLab.DragAndDrop.EffetDeplacement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseGlassMotionListener extends MouseAdapter {

    private MyGlassPane myGlass;

    public MouseGlassMotionListener(MyGlassPane glass){
        myGlass = glass;
    }

    /**
     * Méthode fonctionnant sur le même principe que MouseGlassListener
     * mais cette fois sur l'action de déplacement
     */
    public void mouseDragged(MouseEvent event) {
        Component c = event.getComponent();

        Point p = (Point) event.getPoint().clone();
        SwingUtilities.convertPointToScreen(p, c);
        SwingUtilities.convertPointFromScreen(p, myGlass);
        myGlass.setLocation(p);
        myGlass.repaint();
    }
}