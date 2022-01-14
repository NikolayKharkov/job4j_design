package ru.job4j.ood.spr;

import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class ReportConvertJSON implements Report {
    private Store store;

    public ReportConvertJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return new GsonBuilder().create().toJson(store.findBy(filter));
    }
}