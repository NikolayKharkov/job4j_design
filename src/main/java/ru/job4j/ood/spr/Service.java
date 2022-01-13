package ru.job4j.ood.spr;

public class Service {
    public static void getImage(String path) {
    }

    public static void saveImage(String path) {
    }

    public static void sendEmailMessage(String address, String subject, String text) {
    }

    public static void generateXmlFile(String[] values) {
    }

    /*
     Класс Service имеет четыре метода, с помощью которых выполняет следующий функционал:
     находит IMG, сохраняет IMG, отправка Email, генерация XML
     Данный класс нарушает SPR, т.к выполяет множество функций сразу, что может привести к его частым изменениям
    */
}
