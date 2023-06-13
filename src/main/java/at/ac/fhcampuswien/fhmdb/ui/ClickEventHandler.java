package at.ac.fhcampuswien.fhmdb.ui;

@FunctionalInterface
public interface ClickEventHandler <T>{
    void onClick(T t);
}
