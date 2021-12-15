package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private HashMap<FileProperty, List<Path>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        FileProperty f = new FileProperty(file.toFile().length(), file.toFile().getName());

        if (files.containsKey(f)) {
            List<Path> paths = new ArrayList<>(files.get(f));
            paths.add(file);
            files.put(f, paths);
        } else {
            List<Path> lst = new ArrayList<>();
            lst.add(file);
            files.put(f, lst);
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getDuplicates() {
        List<Path> result = new ArrayList<>();
        files.values()
                .stream()
                .filter(el -> el.size() > 1)
                .forEach(result::addAll);
        return result;
    }
}