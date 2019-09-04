package ru.job4j.srp.ordinary.action;

import ru.job4j.StartUICalc;
import ru.job4j.srp.ordinary.AskNumber;
import ru.job4j.srp.ordinary.BaseAction;
import ru.job4j.srp.ordinary.Input;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Difference extends BaseAction {
    public Difference(int key, String info) {
            super(key, info);
        }

        @Override
        public double execute(Input input, StartUICalc ui) {
            return new BigDecimal(AskNumber.askFirst(input, ui) - AskNumber.askSecond(input, ui))
                    .setScale(3, RoundingMode.UP).doubleValue();
        }
}
