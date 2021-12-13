package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(l -> !l.isEmpty() && !l.startsWith("#"))
                    .map(this::checkFormat)
                    .forEach(l -> this.values.put(l[0], l[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] checkFormat(String line) {
        if (!line.contains("=")) {
            throw new IllegalArgumentException("Not correct format!");
        }
        String[] result = line.split("=");
        if (result.length != 2 || result[0].isEmpty() || result[1].isEmpty()) {
            throw new IllegalArgumentException("Not correct format!");
        }
        return result;
    }

    public String value(String key) {
        return this.values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}