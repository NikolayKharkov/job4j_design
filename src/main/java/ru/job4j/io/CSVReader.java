package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        Path path = Paths.get(argsName.get("path"));
        String out = argsName.get("out");
        String delimiter = argsName.get("delimiter");
        String filter = argsName.get("filter");

        List<String> result = new ArrayList<>();
        Scanner scan = new Scanner(path);
        String header = scan.nextLine();
        List<Integer> desiredIndexes = new ArrayList<>();
        IntStream
                .range(0, header.split(delimiter).length)
                .filter(i -> List.of(filter.split(",")).contains(header.split(delimiter)[i]))
                .forEach(i -> desiredIndexes.add(i));
        result.add(desiredIndexes
                .stream()
                .map(i -> header.split(delimiter)[i])
                .collect(Collectors.joining(delimiter)));

        while (scan.hasNext()) {
            String[] cols = scan.nextLine().split(delimiter);
            result.add(desiredIndexes
                    .stream()
                    .map(i -> cols[i])
                    .collect(Collectors.joining(delimiter)));
        }

        if (out.equals("stdout")) {
            result.forEach(System.out::println);
        } else {
            try (PrintWriter write = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(out)
                    ))) {
                result.forEach(write::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Not correct number of arguments");
        }

        ArgsName listArgs = ArgsName.of(args);

        if (Paths.get(listArgs.get("path")).toFile().isDirectory()
                || !Paths.get(listArgs.get("path")).toFile().exists()) {
            throw new IllegalArgumentException("Not correct PATH parameter!");
        }

        if (!";".equals(listArgs.get("delimiter"))) {
            throw new IllegalArgumentException("Not correct delimiter!");
        }

        handle(listArgs);
    }
}
