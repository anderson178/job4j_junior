package ru.job4j.lsp.action;

import ru.job4j.lsp.ControllQuality;
import ru.job4j.lsp.UIStorageFood;
import ru.job4j.lsp.model.Food;

public class AddFood extends BaseAction {
    public AddFood(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(UIStorageFood ui) {
        Food food = new Food("apple", "11","12",13,"22");
        ControllQuality.distribute(food, ui);
        //System.out.println(this.getClass().getSimpleName() + " ==== hi");
    }
}
