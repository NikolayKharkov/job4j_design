package ru.job4j.ood.spr;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportForHR implements Report {

    private Store store;
    private Comparator sortBySalary;

    public ReportForHR(Store store, Comparator comparator) {
        this.store = store;
        this.sortBySalary = comparator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        text.append(System.lineSeparator());
        List<Employee> employees = store.findBy(filter);
        Collections.sort(employees, sortBySalary);
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
