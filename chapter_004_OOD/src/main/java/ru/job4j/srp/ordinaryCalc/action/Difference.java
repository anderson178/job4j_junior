package ru.job4j.srp.ordinaryCalc.action;

import ru.job4j.srp.ordinaryCalc.BaseAction;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Difference extends BaseAction {
    public Difference(int key, String info) {
            super(key, info);
        }

        @Override
        public double execute(double one, double two) {
            return new BigDecimal(one - two).setScale(3, RoundingMode.UP).doubleValue();
        }
}
