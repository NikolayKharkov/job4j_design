package ru.job4j.io.filesearcher;

import ru.job4j.io.ArgsName;
import ru.job4j.io.SearchFiles;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FilesSearch {

    public static void save(List<Path> paths, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            paths.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Not correct number of arguments!");
        }

        ArgsName listArgs = ArgsName.of(args);

        Path directoryFind = Paths.get(listArgs.get("d"));

        if (!directoryFind.toFile().exists() || !directoryFind.toFile().isDirectory()) {
            throw new IllegalArgumentException("Input directory not correct!");
        }

        String typeOfSearch = listArgs.get("t");
        String resultFile = listArgs.get("o");
        String searchCondition = listArgs.get("n");

        switch (typeOfSearch) {
            case "name":
                save(search(directoryFind, p -> searchCondition.equals(p.toFile().getName())), resultFile);
                break;
            case "mask":
                if (!searchCondition.contains("*")) {
                    throw new IllegalArgumentException("\"MASK\" condition must contains \"*\"!");
                }
                String mask = searchCondition.replace("*", "(\\w*)");
                Pattern patternMask = Pattern.compile(mask);
                save(search(directoryFind, p -> patternMask.matcher(p.toFile().getName()).matches()), resultFile);
                break;
            case "regex":
                Pattern patternRegexp = Pattern.compile(searchCondition);
                save(search(directoryFind, p -> patternRegexp.matcher(p.toFile().getName()).matches()), resultFile);
                break;
            default:
                throw new IllegalArgumentException("Type of search is not correct!");
        }
    }
}
