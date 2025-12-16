package com.example.bar;

public class Cocktail {

    private String name;
    private int price;
    private double alcoholDegrees;
    private double quantity; // en cl ou ml selon le sujet

    public Cocktail (String name, int price, double alcoholDegrees ){
        this.name = name;
        this.price = price;
        this.alcoholDegrees = alcoholDegrees;
        this.quantity = 0.0;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getAlcoholDegrees() {
        return alcoholDegrees;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
