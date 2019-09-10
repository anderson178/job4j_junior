package ru.job4j.lsp;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.storage.Storage;

import java.util.Date;

public class ControllQuality {

    public static void distribute(Food food, UIStorageFood ui) {
        int percent = calculatePercent(food.getCreateDate(), food.getExpiryDate());
        if (food.getExpiryDate().before(new Date(System.currentTimeMillis()))) {
            addFood(ui.getTrash(), food);
        } else if (percent < 25) {
            addFood(ui.getWarehouse(), food);
        } else if (percent >= 25 && percent < 75) {
            addFood(ui.getShop(), food);
        } else if (percent >= 75 && percent < 99) {
            food.setDisscount(50);
            addFood(ui.getShop(), food);
        }
    }

    private static int calculatePercent(Date createDate, Date expiryDate) {
        int periodDays = (int) ((expiryDate.getTime() - createDate.getTime()) / (24 * 60 * 60 * 1000));
        int daysPassed = (int) ((new Date(System.currentTimeMillis()).getTime() - createDate.getTime()) / (24 * 60 * 60 * 1000));
        return (int) ((double) daysPassed / periodDays * 100);
    }

    private static void addFood(Storage storage, Food food) {
        storage.add(food);
    }
}
