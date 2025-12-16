package com.example.bar;

public class Waiter extends Employee {

    public Waiter(String name, int speed, int quality) {
        super(name, speed, quality);
    }

    public void takeOrder (Order order){
        System.out.println(getName() + " prend la commande de " + order.getClient().getName());
    }
}
