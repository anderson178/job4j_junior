package ru.job4j.lsp.action;

import ru.job4j.lsp.controll.ControllQuality;
import ru.job4j.lsp.UIStorageFood;
import ru.job4j.lsp.input.InputInterface;
import ru.job4j.lsp.model.Food;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AddFood extends BaseAction {
    private static final Random RN = new Random();

    public AddFood(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(UIStorageFood ui, InputInterface input) {
        String name = input.ask("Input name the product");
        Date expiryDate = parseDate(input.ask("Input expiry date in the format yyyy-MM-dd of the product"));
        Date createDate = parseDate(input.ask("Input create datein the format yyyy-MM-dd of the product"));
        int price = Integer.parseInt(input.ask("Input price of the product"));
        Food food = new Food(name, expiryDate, createDate, price);
        if (food.getId() == 0) {
            food.setId(generatedId());
        }
        this.runControll(food, ui);

    }

    protected void runControll(Food food, UIStorageFood ui) {
        new ControllQuality().distribute(food, ui);
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    private static long generatedId() {
        return Long.parseLong(String.valueOf(System.currentTimeMillis() + RN.nextInt()));
    }
}
