package ru.job4j.lsp.expansion;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.storage.Storage;

import java.util.List;

public abstract class DecoratorStorage implements Storage {
    private final Storage storage;

    public DecoratorStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void add(Food food) {
        this.storage.add(food);
    }

    @Override
    public void show() {
        this.storage.show();
    }

    @Override
    public List<Food> getFoods() {
       return this.storage.getFoods();
    }
}
