package ru.job4j.ocp.engineer;

import ru.job4j.ocp.engineer.action.Cos;
import ru.job4j.ocp.engineer.action.Sin;
import ru.job4j.srp.ordinary.MenuCalculator;

public class MenuEngineer extends MenuCalculator {

    @Override
    public void fillAction() {
        super.fillAction();
        super.addAction(new Sin(super.getSize(), Sin.class.getSimpleName()));
        super.addAction(new Cos(super.getSize(), Cos.class.getSimpleName()));
    }

}
