package ru.job4j;

import ru.job4j.srp.ordinaryCalc.ConsoleInput;
import ru.job4j.srp.ordinaryCalc.Input;
import ru.job4j.srp.ordinaryCalc.MenuCalculator;
import ru.job4j.srp.ordinaryCalc.action.Difference;
import ru.job4j.srp.ordinaryCalc.action.Divide;
import ru.job4j.srp.ordinaryCalc.action.Multiply;
import ru.job4j.srp.ordinaryCalc.action.Summ;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.08.2019
 */
public class StartUICalc {
    private MenuCalculator menu;
    private Input input;
    public Double result = 0.0;
    public boolean work = true;

    public StartUICalc(Input input, MenuCalculator menu) {
        this.input = input;
        this.menu = menu;
    }

    public void execute() {
        menu.fillDefaultActions(this);
        do {
            this.menu.show();
            int key = input.ask("select: ", menu.fillRange());
            if (key == menu.getSize() - 2 || key == menu.getSize() - 1) {
                this.menu.select(key);
            } else {
                if (this.result.equals(0.0)) {
                    this.result = this.menu.select(key, input.askNumber("Input first number "),
                            input.askNumber("Input second number "));
                    System.out.println(this.result);
                } else {
                    this.result = this.menu.select(key, result, input.askNumber("Input second number "));
                    System.out.println(this.result);
                }
            }

        } while (work);
    }

    public static void main(String[] args) {
        MenuCalculator menu = new MenuCalculator();
        menu.addAction(new Multiply(menu.getSize(), Multiply.class.getSimpleName()));
        menu.addAction(new Divide(menu.getSize(), Divide.class.getSimpleName()));
        menu.addAction(new Difference(menu.getSize(), Difference.class.getSimpleName()));
        menu.addAction(new Summ(menu.getSize(), Summ.class.getSimpleName()));
        new StartUICalc(new ConsoleInput(), menu).execute();
    }
}
