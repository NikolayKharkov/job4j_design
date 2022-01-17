package ru.job4j.ood.parking;

public class ParkingSpace {
    private final Car[] lightsCars;
    private final Car[]trackCars;
    private int spacesForLight;
    private int spacesForTrack;
    public ParkingSpace(int spacesForLight, int spacesForTrack) {
        this.spacesForLight = spacesForLight;
        this.spacesForTrack = spacesForTrack;
        this.lightsCars = new Car[spacesForLight];
        this.trackCars = new Car[spacesForTrack];
    }

    public boolean parkCar(Car car) {
        return false;
    }

    public boolean removeCar(Car car) {
        return false;
    }
}
