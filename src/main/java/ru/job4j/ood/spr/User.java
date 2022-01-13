package ru.job4j.ood.spr;

import java.util.List;

public class User {

    private int age;

    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public List<User> getUsers() {
        return null;
    }

    /*
     Метод getUsers() получает всех пользователей из БД, вернет их в списке.
     Метод getUsers() Нарушает принцип SPR,
     т.к задача класса User, хранить информацию об одном конкретном пользователе,
     а получением информации из бд, должны заниматься другие классы.
    */
}
