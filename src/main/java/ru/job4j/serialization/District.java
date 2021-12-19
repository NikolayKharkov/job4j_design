package ru.job4j.serialization;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

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
}
