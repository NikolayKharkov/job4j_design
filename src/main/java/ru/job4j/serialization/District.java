package ru.job4j.serialization;

import java.util.Arrays;

public class District {
    private final Region region;
    private final String name;
    private final boolean republic;
    private final int population;
    private final String[] towns;

    public District(Region region, String name, boolean republic, int population, String[] towns) {
        this.region = region;
        this.name = name;
        this.republic = republic;
        this.population = population;
        this.towns = towns;
    }

    @Override
    public String toString() {
        return "District{"
                + "region=" + region
                + ", name='" + name + '\''
                + ", republic=" + republic
                + ", population=" + population
                + ", towns=" + Arrays.toString(towns)
                + '}';
    }
}
