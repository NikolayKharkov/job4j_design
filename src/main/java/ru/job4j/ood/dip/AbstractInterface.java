package ru.job4j.ood.dip;

public interface AbstractInterface {
}

class B implements AbstractInterface {

}

class A {
    public void abstractMethdod(B b) {
    }
}

/*
Нарушение принципа DIP, т.к "A" класс теперь зависит от класса "B", для исправления,
 нужно что бы "A" зависел от "AbstractInterface".
 */
