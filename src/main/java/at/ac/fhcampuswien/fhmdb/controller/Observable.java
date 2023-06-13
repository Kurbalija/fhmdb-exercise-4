package at.ac.fhcampuswien.fhmdb.controller;

public interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}