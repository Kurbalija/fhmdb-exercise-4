module at.ac.fhcampuswien.fhmdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires com.google.gson;
    requires okhttp3;
    requires ormlite.jdbc;
    requires java.sql;

    exports at.ac.fhcampuswien.fhmdb;
    exports at.ac.fhcampuswien.fhmdb.model;
    exports at.ac.fhcampuswien.fhmdb.controller;
    exports at.ac.fhcampuswien.fhmdb.exception;
    exports at.ac.fhcampuswien.fhmdb.provider;
    exports at.ac.fhcampuswien.fhmdb.factory;
    exports at.ac.fhcampuswien.fhmdb.sorting;

    opens at.ac.fhcampuswien.fhmdb to javafx.fxml;
    opens at.ac.fhcampuswien.fhmdb.model to com.google.gson, ormlite.jdbc;
    opens at.ac.fhcampuswien.fhmdb.controller to javafx.fxml;
    opens at.ac.fhcampuswien.fhmdb.factory to javafx.fxml;
}