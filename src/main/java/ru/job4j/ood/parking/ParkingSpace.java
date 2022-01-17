package ru.job4j.ood.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {
    private final List<Car> lightsCars;
    private final List<Car> trackCars;
    private int spacesForLight;
    private int spacesForTrack;
    private static final int SPACEONE = 1;

    public ParkingSpace(int spacesForLight, int spacesForTrack) {
        this.spacesForLight = spacesForLight;
        this.spacesForTrack = spacesForTrack;
        this.lightsCars = new ArrayList<>(spacesForLight);
        this.trackCars = new ArrayList<>(spacesForTrack);
    }

    public boolean parkCar(Car car) {
        boolean result = false;
        if (car.getSize() == SPACEONE) {
            result = parkInLight(car);
        } else {
            result = parkInTrack(car);
            if (!result) {
                result = parkInLight(car);
            }
        }
        return result;
    }

    private boolean parkInLight(Car car) {
        boolean result = false;
        int carSize = car.getSize();
        if (spacesForLight >= carSize) {
            spacesForLight -= carSize;
            lightsCars.add(car);
            result = true;
        }
        return result;
    }

    private boolean parkInTrack(Car car) {
        boolean result = false;
        if (spacesForTrack >= SPACEONE) {
            spacesForTrack -= SPACEONE;
            trackCars.add(car);
            result = true;
        }
        return result;
    }

    public boolean removeCar(Car car) {
        boolean result = false;
        if (car.getSize() == SPACEONE) {
            result = removeFromLight(car);
        } else {
            result = removeFromTrack(car);
            if (!result) {
                result = removeFromLight(car);
            }
        }
        return result;
    }

    private boolean removeFromLight(Car car) {
        boolean result = false;
        for (int i = 0; i != lightsCars.size(); i++) {
            if (lightsCars.get(i).equals(car)) {
                result = true;
                lightsCars.remove(i);
                spacesForLight -= car.getSize();
                break;
            }
        }
        return result;
    }

    private boolean removeFromTrack(Car car) {
        boolean result = false;
        for (int i = 0; i != trackCars.size(); i++) {
            if (trackCars.get(i).equals(car)) {
                result = true;
                trackCars.remove(i);
                spacesForTrack -= SPACEONE;
                break;
            }
        }
        return result;
    }

}
