package ru.job4j.lsp.action;

import ru.job4j.lsp.ControllQuality;
import ru.job4j.lsp.UIStorageFood;
import ru.job4j.lsp.model.Food;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddFood extends BaseAction {
    public AddFood(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(UIStorageFood ui) {
        String createDate = "2019-10-";
        Date date1 = parseDate(createDate);
        String expiryDate = "2019-11-24";
        Date date2 = parseDate(expiryDate);
        Date cuurent = parseDate("2019-11-04");

        Date currentDate = new Date(System.currentTimeMillis());
        int p = -0;
        Food food = new Food("apple", parseDate("2019-10-22"), parseDate("2019-07-22"), 13);
        Food food1 = new Food("pc", parseDate("2019-11-22"), parseDate("2019-08-22"), 22);
        Food food2 = new Food("mango", parseDate("2019-09-22"), parseDate("2019-07-24"), 33);
        Food food3 = new Food("pasta", parseDate("2019-09-24"), parseDate("2019-07-14"), 73);
        ControllQuality.distribute(food, ui);
        ControllQuality.distribute(food1, ui);
        ControllQuality.distribute(food2, ui);
        ControllQuality.distribute(food3, ui);
        //System.out.println(this.getClass().getSimpleName() + " ==== hi");
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
