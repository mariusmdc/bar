package com.example.bar;

public class Cocktail {

    protected String name;
    protected int price;
    protected double quantity;

    public Cocktail(String name, int price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " (" + price + "€)";
    }
}
