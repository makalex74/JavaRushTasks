package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    private int cntPassengers;

    public Plane(int cntPassengers) {
        this.cntPassengers = cntPassengers;
    }

    public int getCntPassengers() {
        return cntPassengers;
    }

    @Override
    public void fly() {
        System.out.println("Plane is fly. Count passengers = "+ getCntPassengers());
    }

}
