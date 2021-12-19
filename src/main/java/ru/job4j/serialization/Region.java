package ru.job4j.serialization;

public class Region {
    private final String region;

    public Region(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Region{"
                + "region='" + region + '\''
                + '}';
    }
}
