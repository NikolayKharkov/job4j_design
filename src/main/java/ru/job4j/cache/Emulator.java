package ru.job4j.cache;

import java.nio.file.Paths;

public class Emulator {

    public void load(String dir, String fileName) {
        if (!Paths.get(dir).toFile().exists() || !Paths.get(dir).toFile().isDirectory()) {
            throw new IllegalArgumentException("Not correct input directory!");
        }

        if (!Paths.get(dir, fileName).toFile().exists() || !Paths.get(dir, fileName).toFile().isFile()) {
            throw new IllegalArgumentException("Input file not exists or it's not a file!");
        }
        DirFileCache fileCache = new DirFileCache(dir);
        System.out.println(fileCache.load(fileName));
    }

    public void get(String dir, String fileName) {
        if (!Paths.get(dir).toFile().exists() || !Paths.get(dir).toFile().isDirectory()) {
            throw new IllegalArgumentException("Not correct input directory!");
        }

        if (!Paths.get(dir, fileName).toFile().exists() || !Paths.get(dir, fileName).toFile().isFile()) {
            throw new IllegalArgumentException("Input file not exists or it's not a file!");
        }
        DirFileCache fileCache = new DirFileCache(dir);
        System.out.println(fileCache.get(fileName));
    }
}
