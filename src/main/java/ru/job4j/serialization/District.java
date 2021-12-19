package ru.job4j.serialization;

import javax.xml.bind.annotation.*;
import java.util.Arrays;
import org.json.JSONPropertyIgnore;

@XmlRootElement(name = "district")
@XmlAccessorType(XmlAccessType.FIELD)
public class District {
    private Region region;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private boolean republic;
    @XmlAttribute
    private int population;
    @XmlElementWrapper(name = "towns")
    @XmlElement(name = "town")
    private String[] towns;

    public District() {

    }

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

    @JSONPropertyIgnore
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRepublic() {
        return republic;
    }

    public void setRepublic(boolean republic) {
        this.republic = republic;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String[] getTowns() {
        return towns;
    }

    public void setTowns(String[] towns) {
        this.towns = towns;
    }
}