package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    private final int countOfPassengers;

    public Plane(int countOfPassengers) {
        this.countOfPassengers = countOfPassengers;
    }

    public int getCountOfPassengers() {
        return countOfPassengers;
    }

    @Override
    public void fly() {

    }
}
