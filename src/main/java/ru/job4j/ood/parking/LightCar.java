package ru.job4j.ood.parking;

import java.util.Objects;

public class LightCar extends Car {

    private int size;

    public LightCar(String name) {
        super(name);
        this.size = 1;
    }

    @Override
    int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return size == car.getSize() && Objects.equals(super.getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName(), size);
    }
}
