package ru.job4j.lsp;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.storage.Storage;

public class ControllQuality {

    public static void distribute(Food food, UIStorageFood ui) {
        if (food.getCreateDate() < 25) {
            addFood(ui.getWarehouse(), food);

        } else if (food.getCreateDate() >= 25 && food.getCreateDate() <= 75) {
            addFood(ui.getShop(), food);
        } else if (food.getCreateDate() > 75) {
            food.setDisscount(10);
            addFood(ui.getShop(), food);
        } else {
            addFood(ui.getTrash(), food);
        }

        int p = 0;

        //TODO make condition for redistrubuted the food
    }

    private static void addFood(Storage storage, Food food) {
        storage.add(food);
    }
}
