package com.example.bar;

public class Client {
    private String name;
    private ClientStatus status;

    public Client (String name) {
        this.name = name;
        this.status = ClientStatus.ARRIVED;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public String ToString(){
        return name + " (" + status + ")";
    }
}
