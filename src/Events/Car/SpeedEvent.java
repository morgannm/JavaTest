package Events.Car;

/**
 * Created by morgannm on 12/09/2016.
 */
public class SpeedEvent {
    private int maxSpeed;
    private int minSpeed;
    private int currentSpeed;

    public SpeedEvent(int maxSpeed, int minSpeed, int currentSpeed) {
        // public SpeedEvent(Object source, int maxSpeed, int minSpeed, int currentSpeed) {
        // super(source);
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
        this.currentSpeed = currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }
}
