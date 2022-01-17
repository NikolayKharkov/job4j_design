package ru.job4j.ood.parking;

import org.junit.Assert;
import org.junit.Test;

public class ParkingSpaceTest {

    @Test
    public void whenParkCarSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(3, 0);
        Assert.assertTrue(parkingSpace.parkCar(new LightCar("LightCar")));
    }

    @Test
    public void whenParkCarNotSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(3, 0);
        Assert.assertFalse(parkingSpace.parkCar(new TrackCar("Track", 4)));
    }

    @Test
    public void whenParkFewCarsSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(3, 1);
        parkingSpace.parkCar(new LightCar("LightCar1"));
        parkingSpace.parkCar(new LightCar("LightCar2"));
        Assert.assertTrue(parkingSpace.parkCar(new TrackCar("Track", 2)));
    }

    @Test
    public void whenParkFewCarsNotSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(2, 1);
        parkingSpace.parkCar(new LightCar("LightCar1"));
        parkingSpace.parkCar(new LightCar("LightCar2"));
        parkingSpace.parkCar(new TrackCar("Track", 2));
        Assert.assertFalse(parkingSpace.parkCar(new LightCar("LightCar3")));
    }

    @Test
    public void whenParkTrackIntoLightSpaceSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(2, 1);
        parkingSpace.parkCar(new TrackCar("Track1", 2));
        Assert.assertTrue(parkingSpace.parkCar(new TrackCar("Track2", 2)));
    }

    @Test
    public void whenParkTrackIntoLightSpaceNotSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(2, 1);
        parkingSpace.parkCar(new LightCar("Light"));
        parkingSpace.parkCar(new TrackCar("Track1", 2));
        Assert.assertFalse(parkingSpace.parkCar(new TrackCar("Track2", 2)));
    }

    @Test
    public void whenRemoveCarSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(2, 1);
        TrackCar car = new TrackCar("Track", 2);
        parkingSpace.parkCar(car);
        Assert.assertTrue(parkingSpace.removeCar(car));
    }

    @Test
    public void whenRemoveCarNotSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(2, 1);
        parkingSpace.parkCar(new TrackCar("Track", 2));
        Assert.assertFalse(parkingSpace.removeCar(new LightCar("Car")));
    }
}