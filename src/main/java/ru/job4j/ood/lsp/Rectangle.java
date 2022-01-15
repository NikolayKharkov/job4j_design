package ru.job4j.ood.lsp;

public class Rectangle {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int perimeter() {
        return 2 * height + 2 * width;
    }
}

class Square extends Rectangle {
}
/*
Имеем класс "Rectangle", который описывает прямоугольник.
Появилось требование, добавить класс "Square", который будет описывать квадрат.
Реализация, которая написана выше, явно нарушает принципы LSP,
т.к класс "Square" будет иметь лишнее поле "height", так же будет меняться поведение методов,
что тоже нарушает принципы LSP.
 */