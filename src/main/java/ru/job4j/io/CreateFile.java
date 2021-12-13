package ru.job4j.io;

import java.io.FileOutputStream;

public class CreateFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("even.txt")) {
            out.write("1".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("5".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("15 ".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("17".getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
