package ru.job4j.ood.spr;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}