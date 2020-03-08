package Objects.InterfaceDefault;

public interface Mitose extends Reproduction {
    default void reproduire() {
        System.out.println("Je me divise!");
    }
}
