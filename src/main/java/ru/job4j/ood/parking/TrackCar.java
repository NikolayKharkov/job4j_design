package ru.job4j.ood.parking;

import java.util.Objects;

public class TrackCar extends Car {

    private int size;

    public TrackCar(String name, int size) {
        super(name);
        if (size < 2) {
            throw new IllegalArgumentException("Size for track car must be more than 1");
        }
        this.size = size;
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
