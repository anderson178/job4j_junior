package ru.job4j.srp.ordinary;

import ru.job4j.StartUICalc;

public class AskNumber {

    public static double askFirst(Input input, StartUICalc ui) {
        return ui.result.equals(0.0) ? input.askNumber("Input first number") : ui.result;
    }

    public static double askSecond(Input input, StartUICalc ui) {
        return input.askNumber("Input second number");
    }
}
