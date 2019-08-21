package ru.job4j.srp.ordinaryCalc;

public interface UserAction {
    int key(int key);
    double execute(double one, double two);
    void execute();
    String getInfo();
}
