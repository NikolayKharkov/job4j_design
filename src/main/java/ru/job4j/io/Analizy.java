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
                List<String> temp = read.lines().collect(Collectors.toList());
                for (int i = 0; i != temp.size(); i++) {
                    if (temp.get(i).startsWith("400") || temp.get(i).startsWith("500")) {
                        String startError = temp.get(i).substring(3).trim();
                        for (int j = i + 1; j != temp.size(); j++) {
                            if (!temp.get(j).startsWith("400") && !temp.get(j).startsWith("500")) {
                                write.println(startError
                                        + ";"
                                        + temp.get(j).substring(3).trim()
                                        + ";");
                                i = j;
                                break;
                            }
                        }
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