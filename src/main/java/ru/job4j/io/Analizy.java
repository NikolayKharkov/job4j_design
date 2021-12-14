package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            try (PrintWriter write = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(target)
                    ))) {
                String line = null;
                StringBuilder log = new StringBuilder();
                while ((line = read.readLine()) != null) {
                    if (log.length() == 0 && (line.startsWith("400") || line.startsWith("500"))) {
                        log.append(line.substring(3).trim() + ";");
                    }
                    if (log.length() != 0 && !(line.startsWith("400") || line.startsWith("500"))) {
                        log.append(line.substring(3).trim() + ";");
                        write.println(log);
                        log.setLength(0);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy a = new Analizy();
        a.unavailable("test.txt", "target2.txt");
    }
}