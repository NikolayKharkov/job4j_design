package ru.job4j.ood.spr;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.*;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2017, Calendar.JANUARY, 25);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForHR() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2017, Calendar.JANUARY, 25);
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Anna", now, now, 87);
        Employee worker3 = new Employee("Max", now, now, 35);
        Employee worker4 = new Employee("Kate", now, now, 123);
        Employee worker5 = new Employee("Misha", now, now, 125);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        store.add(worker4);
        store.add(worker5);
        Comparator sortBySalary = new SortBySalary().reversed();
        Report engine = new ReportForHR(store, sortBySalary);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator());
        List<Employee> sortedEmployees = store.findBy(e -> true);
        Collections.sort(sortedEmployees, sortBySalary);
        for (Employee employee : sortedEmployees) {
            expect.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenForAccounting() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2017, Calendar.JANUARY, 25);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForAccounting(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * 0.87).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportForIT() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2017, Calendar.JANUARY, 25);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForIT(store);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "<title>ReportForIt</title>\n"
                        + "</head>\n"
                        + "<body>")
                .append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("</body>\n"
                        + "</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}