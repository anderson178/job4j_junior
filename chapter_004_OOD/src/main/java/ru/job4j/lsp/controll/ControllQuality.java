package ru.job4j.lsp.controll;

import ru.job4j.lsp.UIStorageFood;
import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.storage.Storage;

public class ControllQuality {

    public void distribute(Food food, UIStorageFood ui) {
        for (Storage storage : ui.getStorages()) {
            if (storage.accept(food)) {
                addFood(storage, food);
                break;
            }
        }
    }

    protected void addFood(Storage storage, Food food) {
        storage.add(food);
    }
}
