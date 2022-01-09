package ru.job4j.cache;

import java.nio.file.Paths;

public class Emulator {
    private DirFileCache dirFileCache;

    public Emulator(String dir) {
        if (!Paths.get(dir).toFile().exists()
                || !Paths.get(dir).toFile().isDirectory()
                || !Paths.get(dir).toFile().exists()) {
            throw new IllegalArgumentException("Not correct input directory!");
        }
        this.dirFileCache = new DirFileCache(dir);
    }

    public void load(String fileName) throws Exception {
        System.out.println(dirFileCache.load(fileName));
    }

    public void get(String fileName) throws Exception {
        System.out.println(dirFileCache.get(fileName));
    }

    public static void main(String[] args) throws Exception {
        Emulator a = new Emulator("C:\\cache");
        a.load("names.txt");
    }
}
