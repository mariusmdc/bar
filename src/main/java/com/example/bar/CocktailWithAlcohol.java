package com.example.bar;

public class CocktailWithAlcohol extends Cocktail{

    private double alcoholDegrees ;

    public CocktailWithAlcohol(String name, int price, double quantity, double alcoholDegrees) {
        super(name, price, quantity);
        this.alcoholDegrees = alcoholDegrees;
    }

    public double getAlcoholDegrees() {
        return alcoholDegrees;
    }

    @Override
    public String toString() {
        return name + " (" + price + "€) - " + alcoholDegrees + "°";
    }
}
