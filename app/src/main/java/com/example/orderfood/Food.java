package com.example.orderfood;

import java.io.Serializable;

public class Food implements Serializable {
    String name;
    int quantity;

    public Food(String name) {
        this.name = name;
    }

    public Food(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
