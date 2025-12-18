package com.example.bar;

public class CocktailNoAlcohol extends Cocktail {


    public CocktailNoAlcohol(String name, int price, double quantity) {
        super(name, price, quantity);
    }

    @Override
    public String toString() {
        return name + " (" + price + "€) - Without alcohol" ;
    }
}

