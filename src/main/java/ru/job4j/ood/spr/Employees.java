package ru.job4j.ood.spr;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {

    @XmlElement(name = "employee")
    private List<Employee> employees;

    public Employees() {
    }

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<? extends Employee> getEmployees() {
        return employees;
    }

    public void setUsers(List<Employee> users) {
        this.employees = employees;
    }
}
