package Objects.InterfaceDefault;

public interface Pondre extends Reproduction {
    default void reproduire() {
        System.out.println("Je ponds des oeufs!");
    }
}
