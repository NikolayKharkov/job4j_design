package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Empty args exception!");
        }
        Arrays.stream(args)
                .map(this::checkFormat)
                .forEach(arg -> this.values.put(arg[0].substring(1), arg[1]));
    }

    public String[] checkFormat(String line) {
        if (!line.contains("=")) {
            throw new IllegalArgumentException("Not correct format!");
        }
        String[] result = line.split("=");
        if (result.length != 2 || result[0].isEmpty() || result[1].isEmpty() || !result[0].startsWith("-")) {
            throw new IllegalArgumentException("Not correct format!");
        }
        return result;
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}