package ru.job4j.ood.products;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    private List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public boolean putProduct(Food food) {
        boolean result = false;
        for (Storage storage : storages) {
            if (result) {
                break;
            }
            result = storage.putFood(food);
        }
        return result;
    }

    public List<Food> getProducts() {
        List<Food> result = new ArrayList<>();
        for (Storage storage : storages) {
            result.addAll(storage.getFoods());
        }
        return result;
    }

    public void resort() {
        List<Food> resorting = getProducts();
        storages.stream().forEach(Storage::removeAllProducts);
        resorting.stream().forEach(food -> putProduct(food));
    }
}
