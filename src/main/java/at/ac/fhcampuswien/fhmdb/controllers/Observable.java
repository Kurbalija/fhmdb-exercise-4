package at.ac.fhcampuswien.fhmdb.controllers;

public interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}