package ru.job4j.lsp.expansion;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.storage.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WarehouseAdditional extends Warehouse {
    private List<Food> foodList = new ArrayList<>();

    @Override
    public void add(Food food) {
        this.foodList.add(food);
    }

    @Override
    public void show() {
        IntStream.range(0, this.foodList.size()).forEach(i
                -> System.out.println(getClass().getSimpleName() + " " + i + ":" + " " + this.foodList.get(i)));
    }

    @Override
    public List<Food> getFoods() {
        return this.foodList;
    }
}
