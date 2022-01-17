package ru.job4j.ood.parking;

import java.util.Objects;

public class LightCar extends Car {

    public static final int SIZE = 1;

    public LightCar(String name) {
        super(name);
    }

    @Override
    int getSize() {
        return SIZE;
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
        return SIZE == car.getSize() && Objects.equals(super.getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName(), SIZE);
    }
}
