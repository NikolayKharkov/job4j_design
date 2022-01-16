package ru.job4j.ood.products;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public interface Storage {
    public boolean putFood(Food food);

    public boolean accept(Food food);

    default double returnExpirationPercent(Food food) {
        LocalDate now = LocalDate.now();
        LocalDate createDate = food.getCreateDate();
        LocalDate expiryDate = food.getExpiryDate();
        Duration expirationDays = Duration.between(createDate.atStartOfDay(), expiryDate.atStartOfDay());
        Duration passedDays = Duration.between(createDate.atStartOfDay(), now.atStartOfDay());
        return Math.round((double) passedDays.toDays() / expirationDays.toDays() * 100);
    }

    public List<Food> getFoods();
}
