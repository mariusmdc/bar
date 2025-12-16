package com.example.bar;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Cocktail> cocktails = new ArrayList<>();
    private double bill;
    private Client client;
    private double happyHourReduc = 0.0;

    public Order (Client client){
        this.client = client;
        this.bill = 0;
    }

    public void setHappyHourReduc(double happyHourReduc) {
        this.happyHourReduc = happyHourReduc;
    }

    public void addCocktail (Cocktail c){
        cocktails.add(c);
    }

    public void removeCocktail (Cocktail c){
        cocktails.remove(c);
    }

    public double calculateBill (){
        double total = 0;
        for (Cocktail c : cocktails){
            total += c.getPrice();
        }
        bill = total * (1 - happyHourReduc);
        return bill;
    }

    public List<Cocktail> getCocktails() {
        return cocktails;
    }

    public double getBill() {
        return bill;
    }

    public Client getClient() {
        return client;
    }
}
