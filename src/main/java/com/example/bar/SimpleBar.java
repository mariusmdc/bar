package com.example.bar;

import java.util.ArrayList;
import java.util.List;

public class SimpleBar implements Bar {

    private List<Client> clients = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<Cocktail> cocktails = new ArrayList<>();
    private boolean happyHour = false;

    @Override
    public Client addClient(String name) {
        Client c = new Client(name);
        clients.add(c);
        return c;
    }

    @Override
    public void removeClient(Client c) {
        clients.remove(c);
    }

    @Override
    public Order createOrder(Client c) {
        Order o = new Order(c);
        if (happyHour){
            o.setHappyHourReduc(0.2);
        } else {
            o.setHappyHourReduc(0.0);
        }
        orders.add(o);
        return o;
    }

    @Override
    public void prepareOrder(Order order, Barman barman) {
        barman.prepareCocktail(order);
        // ici tu pourras changer statut commande + client si le sujet le demande
    }

    @Override
    public double billOrder(Order order) {
        return order.calculateBill();
    }

    @Override
    public void startHappyHour() {
        happyHour = true;
        for (Order o : orders){
            o.setHappyHourReduc(0.2);
        }
    }

    @Override
    public void endHappyHour() {
        happyHour = false;
        for (Order o : orders){
            o.setHappyHourReduc(0.0);
        }
    }

    // utile pour l'interface JavaFX : liste des cocktails disponibles au bar
    public void addCocktailToMenu(Cocktail cocktail) {
        cocktails.add(cocktail);
    }

    public List<Cocktail> getCocktailMenu() {
        return cocktails;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
