package com.example.bar;

public class Employee {

    private String name;
    private int speed;
    private int quality;

    public Employee(String name, int speed, int quality){
        this.name = name;
        this.speed = speed;
        this.quality = quality;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getQuality() {
        return quality;
    }

    public int getSkillScore() {
        return speed + quality;
    }
}
