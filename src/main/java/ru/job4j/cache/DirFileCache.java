package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(cachingDir + "\\" + key))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                result.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}