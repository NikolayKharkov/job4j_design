package ru.job4j.ood.menu;

import java.util.LinkedList;
import java.util.Queue;

public class Menu implements Add, FindBy, ShowMenu {

    private final Node root;

    public Menu(Node root) {
        this.root = root;
    }

    @Override
    public boolean add(Task main, Task sub) {
        boolean rsl = false;
        Node node = findBy(main.getName());
        if (node != null) {
            node.getChildren().add(new Node(sub));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Node findBy(String name) {
        Node result = null;
        Queue<Node> data = new LinkedList<>();
        data.add(this.root);
        while (!data.isEmpty()) {
            Node el = data.poll();
            if (el.getTask().getName().equals(name)) {
                result = el;
                break;
            }
            data.addAll(el.getChildren());
        }
        return result;
    }

    public String show() {
        StringBuilder builder = new StringBuilder();
        for (Node node : root.getChildren()) {
            builder.append(showMenu(node, 0));
        }
        return builder.toString();
    }

    private String showMenu(Node node, int depth) {
        StringBuilder builder = new StringBuilder();
        String tab = "----".repeat(depth);
        builder.append(tab).append(node.getTask().getName()).append(System.lineSeparator());

        if (node.getChildren().size() > 0) {
            for (Node child : node.getChildren()) {
                builder.append(showMenu(child, depth + 1));
            }
        }
        return builder.toString();
    }

    public UserAction choose(Task task) throws Exception {
        Task currentTask = findBy(task.getName()).getTask();
        if (currentTask == null) {
            throw new Exception("Task not found!");
        }
        return () -> System.out.print("You choose: " + currentTask.getName());
    }
}