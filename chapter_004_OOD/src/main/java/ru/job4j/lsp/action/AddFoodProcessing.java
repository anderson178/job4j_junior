package ru.job4j.lsp.action;

import ru.job4j.lsp.UIStorageFood;
import ru.job4j.lsp.controll.ControllQualityOptional;
import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.model.FoodReproduct;

import java.util.Date;

public class AddFoodProcessing extends AddFood {
    public AddFoodProcessing(int key, String info) {
        super(key, info);
    }

    protected void runControll(Food food, UIStorageFood ui) {
        FoodReproduct foodReproduct = new FoodReproduct(food, false);
        if (foodReproduct.getFood().getExpiryDate().before(new Date(System.currentTimeMillis()))) {
            foodReproduct.setCanReproduct(true);
        }
        new ControllQualityOptional().distribute(foodReproduct, ui);
    }
}
