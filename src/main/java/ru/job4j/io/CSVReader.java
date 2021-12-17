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
        if (path.toFile().isDirectory() || !path.toFile().exists()) {
            throw new IllegalArgumentException("Not correct PATH parameter!");
        }

        if (!out.equals("stdout") && (!Paths.get(out).toFile().exists() || Paths.get(out).toFile().isDirectory())) {
            throw new IllegalArgumentException("Not correct OUT parameter!");
        }

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

        switch (out) {
            case "stdout":
                result.forEach(System.out::println);
                break;
            default:
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
}
