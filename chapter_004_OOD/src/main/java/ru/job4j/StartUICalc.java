package ru.job4j;

import ru.job4j.ocp.engineer.MenuEngineer;
import ru.job4j.ocp.engineer.action.Sin;
import ru.job4j.srp.ordinary.ConsoleInput;
import ru.job4j.srp.ordinary.Input;
import ru.job4j.srp.ordinary.MenuCalculator;

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
            menu.show();
            int key = input.ask("select: ", menu.fillRange());
            this.result = menu.select(key, input, this);
            if (key != menu.getSize() - 1 && key != menu.getSize() - 2) {
                System.out.println(result);
            }
        } while (work);
    }

    public static void main(String[] args) {
        MenuCalculator menu = new MenuEngineer();
        menu.addAction(new Sin(menu.getSize(), Sin.class.getSimpleName()));
        new StartUICalc(new ConsoleInput(), menu).execute();
    }
}
