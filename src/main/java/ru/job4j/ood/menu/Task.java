package ru.job4j.ood.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task {

    private final String name;
    private List<Task> children = new ArrayList<>();

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Task task) {
        children.add(task);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return name.equals(task.name) && Objects.equals(children, task.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children);
    }
}