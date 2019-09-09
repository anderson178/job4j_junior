package ru.job4j.lsp;

import ru.job4j.lsp.model.Food;

public class ControllQuality {

    public static void distribute(Food food, UIStorageFood ui) {

        ui.getShop().add(food);

        //TODO make condition for redistrubuted the food
    }
}
