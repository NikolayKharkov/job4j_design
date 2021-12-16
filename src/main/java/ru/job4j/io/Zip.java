package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ru.job4j.io.Search.search;

public class Zip {

    public static void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            for (Path p : sources) {
                zip.putNextEntry(new ZipEntry(p.toFile().getPath()));
                BufferedInputStream out = new BufferedInputStream(new FileInputStream(p.toFile()));
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 3) {
            throw new IllegalArgumentException("Not correct number of arguments!");
        }

        ArgsName listArgs = ArgsName.of(args);

        if (!Paths.get(listArgs.get("d")).toFile().exists()
                || !Paths.get(listArgs.get("d")).toFile().isDirectory()) {
            throw new IllegalArgumentException("Ziped directory is not exist or it's not a directory");
        }

        List<Path> listPaths = search(Paths.get(listArgs.get("d")),
                p -> !p.toFile().getName().endsWith(listArgs.get("e")));

        packFiles(listPaths, Paths.get(listArgs.get("o")));
    }
}