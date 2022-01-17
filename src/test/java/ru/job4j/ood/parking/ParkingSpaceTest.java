package ru.job4j.ood.parking;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ParkingSpaceTest {

    @Ignore
    @Test
    public void whenParkCarSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(3, 0);
        Assert.assertTrue(parkingSpace.parkCar(new LightCar("LightCar")));
    }

    @Ignore
    @Test
    public void whenParkCarNotSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(3, 0);
        Assert.assertFalse(parkingSpace.parkCar(new TrackCar("Track", 4)));
    }

    @Ignore
    @Test
    public void whenParkFewCarsSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(3, 1);
        parkingSpace.parkCar(new LightCar("LightCar1"));
        parkingSpace.parkCar(new LightCar("LightCar2"));
        Assert.assertTrue(parkingSpace.parkCar(new TrackCar("Track", 2)));
    }

    @Ignore
    @Test
    public void whenParkFewCarsNotSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(2, 1);
        parkingSpace.parkCar(new LightCar("LightCar1"));
        parkingSpace.parkCar(new LightCar("LightCar2"));
        parkingSpace.parkCar(new TrackCar("Track", 2));
        Assert.assertFalse(parkingSpace.parkCar(new LightCar("LightCar3")));
    }

    @Ignore
    @Test
    public void whenParkTrackIntoLightSpaceSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(2, 1);
        parkingSpace.parkCar(new TrackCar("Track1", 2));
        Assert.assertTrue(parkingSpace.parkCar(new TrackCar("Track2", 2)));
    }

    @Ignore
    @Test
    public void whenParkTrackIntoLightSpaceNotSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(2, 1);
        parkingSpace.parkCar(new LightCar("Light"));
        parkingSpace.parkCar(new TrackCar("Track1", 2));
        Assert.assertFalse(parkingSpace.parkCar(new TrackCar("Track2", 2)));
    }

    @Ignore
    @Test
    public void whenRemoveCarSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(2, 1);
        TrackCar car = new TrackCar("Track", 2);
        parkingSpace.parkCar(car);
        Assert.assertTrue(parkingSpace.removeCar(car));
    }

    @Ignore
    @Test
    public void whenRemoveCarNotSuccefully() {
        ParkingSpace parkingSpace = new ParkingSpace(2, 1);
        parkingSpace.parkCar(new TrackCar("Track", 2));
        Assert.assertFalse(parkingSpace.removeCar(new LightCar("Car")));
    }

    @Ignore
    @Test
    public void whenParkTrackIntoLightSpaceWithEnoughSpaceButNotOnEachOther() {
        ParkingSpace parkingSpace = new ParkingSpace(4, 0);
        LightCar car1 = new LightCar("Car1");
        LightCar car2 = new LightCar("Car2");
        LightCar car3 = new LightCar("Car3");
        LightCar car4 = new LightCar("Car4");
        parkingSpace.parkCar(car1);
        parkingSpace.parkCar(car2);
        parkingSpace.parkCar(car3);
        parkingSpace.parkCar(car4);
        parkingSpace.removeCar(car2);
        parkingSpace.removeCar(car4);
        Assert.assertFalse(parkingSpace.parkCar(new TrackCar("Track", 2)));
    }
}