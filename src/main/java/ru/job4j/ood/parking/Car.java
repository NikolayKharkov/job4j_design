package ru.job4j.ood.parking;

public abstract class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    abstract int getSize();

    @Override
    public abstract boolean equals(Object o);


    @Override
    public abstract int hashCode();

    public String getName() {
        return name;
    }
}