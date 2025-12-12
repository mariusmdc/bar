package com.example.bar;

public class Cocktail {

    private String name;
    private int price;
    private double alcoholDegrees;
    private double quantity;

    public Cocktail (String name, int price, double alcoholDegrees ){
        this.name = name;
        this.price = price;
        this.alcoholDegrees = alcoholDegrees;
    }
    public int getPrice() {
        return price;
    }

}
