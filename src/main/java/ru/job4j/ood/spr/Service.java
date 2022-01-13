package ru.job4j.ood.spr;

public class Service {
    //вернуть изображение
    public static void getImage(String path) {
    }

    //сохранить изображение
    public static void saveImage(String path) {
    }

    //отправить email
    public static void sendEmailMessage(String address, String subject, String text) {
    }

    //сгенерировать новый файл xml
    public static void generateSiteMapFile(String[] values) {
    }
    // Класс Service имеет четыре метода, с помощью которых выполняет следующий функционал:
    // находит IMG, сохраняет IMG, отправка Email, генерация XML
    // Данный класс нарушает SPR, т.к выполяет множество функций сразу, что может привести к его частым изменениям
}
