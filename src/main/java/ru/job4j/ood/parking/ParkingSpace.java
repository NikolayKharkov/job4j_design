package ru.job4j.ood.parking;

import java.util.List;

public interface ParkingSpace {
    public void createParking(int spacesForLight, int spacesForTrack);
    public boolean parkCar(Car car);
    public boolean removeCar(Car car);
    public List<Car> returnAllLightCars();
    public List<Car> returnAllTrackCars();
}
