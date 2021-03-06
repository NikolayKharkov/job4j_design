package ru.job4j.ood.ocp;

public class Shape {
    public double square(double side1, double side2) {
        return side1 * side2;
    }

    /* Класс "фигура", имеет метод "square", который расчитывает площадь для квадрата.
       Требование изменилось, теперь мы считаем площадь круга.
       В случаи, если мы изменим метод "square", то это будет нарушение принципа OCP, данный класс будет изменен.
       Для выхода из данной ситуации, нужно создать interface "Shape",
       а потом с его помощью, реализовывать нужные нам фигуры.
    */
}
