package ru.job4j.srp.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class MenuEngineer extends MenuCalculator {


    @Override
    public void fillActions(StartUICalc ui) {
        super.fillActions(ui);
        super.userActions.add(new NewSumm(6, "NewSumm"));
    }

    @Override
    public List<Integer> fillRange() {
        return super.fillRange();
    }

    @Override
    public double select(int key, double first, double second) {
        return super.select(key, first, second);
    }

    @Override
    public void select(int key) {
        super.select(key);
    }

    @Override
    public void show() {
        super.show();
    }

    private class NewSumm extends BaseAction {


        public NewSumm(int key, String info) {
            super(key, info);
        }

        @Override
        public double execute(double one, double two) {
            return new BigDecimal(one + two * one).setScale(3, RoundingMode.UP).doubleValue();

        }
    }
}
