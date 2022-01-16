package ru.job4j.ood.products;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    private List<Food> trash = new ArrayList<>();

    @Override
    public boolean putFood(Food food) {
        boolean result = false;
        if (accept(food)) {
            trash.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public boolean accept(Food food) {
        boolean result = false;
        if (!food.isFresh()) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Food> getFoods() {
        return List.copyOf(trash);
    }
}
