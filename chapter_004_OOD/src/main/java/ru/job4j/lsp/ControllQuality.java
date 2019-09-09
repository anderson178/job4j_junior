package ru.job4j.lsp;

import ru.job4j.lsp.model.Food;

public class ControllQuality {

    public static void distribute(Food food, UIStorageFood ui) {
        if (food.getCreateDate() < 25) {
            ui.getStorages().get(2).add(food);
        } else if (food.getCreateDate() >= 25 && food.getCreateDate() <=75) {
            ui.getStorages().get(0).add(food);
        } else if (food.getCreateDate() > 75){
            food.setDisscount(10);
            ui.getStorages().get(0).add(food);
        } else {
            ui.getStorages().get(1).add(food);
        }

        int p = 0;

        //TODO make condition for redistrubuted the food
    }
}
