package ru.job4j.tracker;



import java.util.ArrayList;
import java.util.function.Consumer;

public class ValidateInput implements ru.job4j.tracker.Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question, Consumer<String> show) {
        return this.input.ask(question, System.out::println);
    }
    @Override
    public int ask(String question, Consumer<String> show, ArrayList<Integer> range) {
        boolean invalide = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, System.out::println, range);
                invalide = false;
            } catch (MenuOutExeption moe) {
                System.out.println("Enter number menu  of range");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
            }
        }
        while (invalide);
        return value;
    }
}
