package ru.job4j.ood.spr;

import java.util.function.Predicate;

public class ReportForIT implements Report {

    private Store store;

    public ReportForIT(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "<title>ReportForIt</title>\n"
                        + "</head>\n"
                        + "<body>")
                .append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</body>\n"
                + "</html>");
        return text.toString();
    }
}
