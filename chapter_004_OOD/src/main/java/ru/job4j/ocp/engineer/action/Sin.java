package ru.job4j.ocp.engineer.action;

import ru.job4j.StartUICalc;
import ru.job4j.srp.ordinary.BaseAction;
import ru.job4j.srp.ordinary.Input;

public class Sin extends BaseAction {
    public Sin(int key, String info) {
        super(key, info);
    }

    @Override
    public double execute(Input input, StartUICalc ui) {
        ui.result = Math.sin(input.askNumber("Input number"));
        return ui.result;
    }
}
