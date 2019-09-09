package ru.job4j.lsp.storage;

import ru.job4j.lsp.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Warehouse implements Storage {
    private List<Food> foodList = new ArrayList<>();
    @Override
    public void add(Food food) {
        this.foodList.add(food);
    }

    @Override
    public void show() {
        System.out.println("-----------MENU--------");
        IntStream.range(0, this.foodList.size()).forEach(i
                -> System.out.println(i + ":" + " " + this.foodList.get(i)));
        System.out.println("-----------------------");
    }
}
