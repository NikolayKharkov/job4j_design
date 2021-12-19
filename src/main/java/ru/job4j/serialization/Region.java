package ru.job4j.serialization;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "region")
public class Region {
    @XmlAttribute
    private String region;

    public Region() {

    }

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
