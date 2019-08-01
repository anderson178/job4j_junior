package ru.job4j.srp.calculator;

public interface UserAction {
    int key(int key);
    double execute(double one, double two);
    void execute();
    String getInfo();
}
