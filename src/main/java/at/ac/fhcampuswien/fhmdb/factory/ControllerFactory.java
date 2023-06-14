package at.ac.fhcampuswien.fhmdb.factory;

import javafx.util.Callback;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory implements Callback<Class<?>, Object> {
    private static final Map<Class<?>, Object> instances = new HashMap<>();

    @Override
    public Object call(Class<?> aClass) {
        if (!instances.containsKey(aClass)) {
            try {
                instances.put(aClass, aClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instances.get(aClass);
    }
}