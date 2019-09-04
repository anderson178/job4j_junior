package ru.job4j.srp.ordinary;

import ru.job4j.StartUICalc;

public interface UserAction {
    int key(int key);
    double execute(Input input, StartUICalc ui);
    //double execute(double one, double two);
    //void execute();
    String getInfo();
}
