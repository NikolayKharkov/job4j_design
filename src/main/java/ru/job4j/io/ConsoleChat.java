package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        if (!Paths.get(botAnswers).toFile().exists() || !Paths.get(path).toFile().isDirectory()) {
            throw new IllegalArgumentException("Input botAnswers file not exists or path is not directory!");
        }
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> botAnswers = readPhrases();
        List<String> log = new ArrayList<>();
        boolean stop = false;
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        do {
            if (userInput.equalsIgnoreCase(STOP)) {
                stop = true;
            }
            if (userInput.equalsIgnoreCase(CONTINUE)) {
                stop = false;
            }
            if (stop) {
                log.add("Пользователь: " + userInput);
                userInput = input.nextLine();
            }
            if (!stop) {
                String botAnswer = botAnswers.get((int) (Math.random() * botAnswers.size()));
                System.out.println(botAnswer);
                log.add("Пользователь: " + userInput);
                log.add("Бот: " + botAnswer);
                userInput = input.nextLine();
            }
        }
        while (!userInput.equalsIgnoreCase(OUT));
        log.add("Пользователь: " + userInput);
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            result = in.lines()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
            log.forEach(pw::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/logBot.txt", "./data/typicalWomanBot.txt");
        cc.run();
    }
}