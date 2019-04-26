package Events.Car;

/**
 * Created by morgannm on 12/09/2016.
 */
public interface SpeedListener {
    public void speedExceeded(SpeedEvent e);
    public void speedGoneBelow(SpeedEvent e);
}
