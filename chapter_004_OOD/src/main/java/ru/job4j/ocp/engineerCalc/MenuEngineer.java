package ru.job4j.ocp.engineerCalc;

import ru.job4j.StartUICalc;
import ru.job4j.srp.ordinaryCalc.Input;
import ru.job4j.srp.ordinaryCalc.MenuCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MenuEngineer extends MenuCalculator {
    protected List<UserActionEngineer> userActions = new ArrayList<>();
    List<Integer> range = new ArrayList<>();

    @Override
    public void fillActions(StartUICalc ui) {
       // super.fillActions(ui);
        this.userActions.add(new Sin(0, "Sin"));
        this.userActions.add(new Cos(1, "Cos"));
    }

    @Override
    public List<Integer> fillRange() {
        IntStream.range(0, this.userActions.size()).forEach(range::add);
        return this.range;
    }


    public void select(int key, double number) {
        this.userActions.get(key).execute(number);
    }

    public void menuDialog(Input input, StartUICalc ui) {
        //int key = input.ask("select: ", this.fillRange());
//        double rst1 = input.askNumber("Input first number");
//        int key2 = input.ask("select: ", this.fillRange());
//        double rst2 = input.askNumber("Input second number");
       //System.out.println(this.userActions.get(key).getInfo());
        //super.fillActions(ui);

       // super.fillRange();

    }

    @Override
    public void show() {
      // super.show();
        System.out.println("-----------MENU--------");
        IntStream.range(0, this.userActions.size()).forEach(i
                -> System.out.println(i + ":" + " " + this.userActions.get(i).getInfo()));
        System.out.println("-----------------------");
    }

    private class Sin extends BaseActionEngineer {

        public Sin(int key, String info) {
            super(key, info);
        }

        @Override
        public double execute(double number) {
            return Math.sin(number);
        }
    }

    private class Cos extends BaseActionEngineer {

        public Cos(int key, String info) {
            super(key, info);
        }

        @Override
        public double execute(double number) {
            return Math.cos(number);
        }
    }


}
