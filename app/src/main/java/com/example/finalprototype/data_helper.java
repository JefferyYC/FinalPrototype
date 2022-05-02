package com.example.finalprototype;

public class data_helper {

    public static data d;

    public static data getData() {
        if (d == null) {
            d = new data();
            return d;
        }
        return d;
    }
}
