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
        Food food = new Food("apple", "11",12,13);
        Food food1 = new Food("pc", "11",45,22);
        Food food2 = new Food("mango", "11",80,33);
        Food food3 = new Food("pasta", "11",74,73);
        ControllQuality.distribute(food, ui);
        ControllQuality.distribute(food1, ui);
        ControllQuality.distribute(food2, ui);
        ControllQuality.distribute(food3, ui);
        //System.out.println(this.getClass().getSimpleName() + " ==== hi");
    }
}
