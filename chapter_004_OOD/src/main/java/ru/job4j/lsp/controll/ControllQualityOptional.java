package ru.job4j.lsp.controll;

import ru.job4j.lsp.UIStorageFood;
import ru.job4j.lsp.model.FoodReproduct;
import ru.job4j.lsp.storage.Storage;

public class ControllQualityOptional extends ControllQuality {

    public void distribute(FoodReproduct food, UIStorageFood ui) {
        for (Storage storage : ui.getStorages()) {
            if (storage.accept(food.getFood()) && food.isCanReproduct()) {
                super.addFood(storage, food.getFood());
                break;
            }
        }
    }

}
