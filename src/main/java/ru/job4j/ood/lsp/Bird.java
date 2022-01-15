package ru.job4j.ood.lsp;

public class Bird {
    public void fly() {
    }
}

class Penguin extends Bird {
}

/*
Имеем класс Bird, с методом "fly".
Создаем класс "Penguin", который наследуется от "Bird".
Да, пингвины птицы, но они не умеют летать.
Такая реализация нарушает принцип LSP, т.к ломается поведение объектов.
*/




