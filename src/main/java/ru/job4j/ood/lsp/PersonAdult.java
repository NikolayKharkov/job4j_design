package ru.job4j.ood.lsp;

public class PersonAdult {
    private int age;
    private int name;

    public PersonAdult(int age, int name) {
        this.age = age;
        this.name = name;
    }

    public void getDrive() {
    }
}

class PersonTeenager extends PersonAdult {

    public PersonTeenager(int age, int name) {
        super(age, name);
    }

    @Override
    public void getDrive() {
        if (this.getClass() == PersonTeenager.class) {
            System.out.println("Too young to drive!");
        }
    }
}
/*
Имеем класс "PersonAdult",описывает взрослого человека, который может сесть за руль.
От него наследуется класс "PersonTeenager", который описывает подростка.
Подросткам нельзя за руль, но поскольку он наследует метод, при его вызове нам нужно сделать проверку,
и не допустить его за руль.
Здесь происходит нарушение LSP, т.к метод меняет свое поведение.
Косвенно на нарушение указывает метод "getClass()",
а так же присутствие адаптации под реализацию.
*/
