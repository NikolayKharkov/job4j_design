package ru.job4j.ood.dip;

public class Worker {
    public void workComputer(Windows windows) {
        windows.work();
    }
}

class Windows {
    public void work() {
        System.out.println("Work on Windows machine");
    }
}

/*
Имеем класс "Worker" рабочий, который имеет метод "workComputer", в аргументы передается ОС.
 Получается класс "Worker", будет зависеть от класса Windows, т.к он не может работать с другими ОС.
 */
