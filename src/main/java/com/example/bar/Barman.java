package com.example.bar;

public class Barman extends Employee {

    public Barman(String name, int speed, int quality) {
        super(name, speed, quality);
    }

    public void prepareCocktail (Order order){
        System.out.println(getName() + " prépare la commande de " + order.getClient().getName());
    }
}
