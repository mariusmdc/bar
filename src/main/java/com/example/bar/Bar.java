package com.example.bar;

public interface Bar {

    Client addClient (String name);

    void removeClient (Client c);

    Order createOrder (Client c);

    void prepareOrder (Order order, Barman barman);

    double billOrder (Order order);

    void startHappyHour ();

    void endHappyHour ();
}
