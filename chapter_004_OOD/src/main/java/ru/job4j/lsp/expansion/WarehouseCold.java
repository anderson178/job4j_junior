package ru.job4j.lsp.expansion;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.storage.Storage;
import ru.job4j.lsp.storage.Warehouse;

public class WarehouseCold extends DecoratorStorage {
    private final int temperature;

    public WarehouseCold(Storage storage, int temperature) {
        super(storage);
        this.temperature = temperature;
    }

    @Override
    public boolean accept(Food food) {
        return new Warehouse().accept(food);
    }
}
