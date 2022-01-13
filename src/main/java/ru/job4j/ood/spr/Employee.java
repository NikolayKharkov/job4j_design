package ru.job4j.ood.spr;

public class Employee {
    private String name;
    private int yearExperience;
    private int salary;

    public Employee(String name, int yearExperience, int salary) {
        this.name = name;
        this.yearExperience = yearExperience;
        this.salary = salary;
    }

    public void raiseSalary(int newSalary) {
        this.salary = newSalary;
    }

    /*
      Нарушение заключается в том, что сотрудник не может сам себе повысить зарплату.
      Это должы делать строние классы, который будут иметь свою логику, для повышения.
    */

}
