package DesignPatterns.Observer;

public interface Observable {
    void addObservateur(Observateur obs);
    void updateObservateur();
    void delObservateur();
}
