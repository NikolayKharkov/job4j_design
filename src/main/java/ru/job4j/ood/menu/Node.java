package ru.job4j.ood.menu;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final Task task;
    private List<Node> children = new ArrayList<Node>();
    private UserAction action;

    public Node(Task task, UserAction action) {
        this.task = task;
        this.action = action;
    }

    public Node(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public List<Node> getChildren() {
        return children;
    }
}