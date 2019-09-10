package ru.job4j.lsp.input;

import java.util.List;

public class ValidateInput implements InputInterface {

    private final InputInterface input;

    public ValidateInput(InputInterface input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return null;
    }

    @Override
    public int ask(String question, List<Integer> range) {
        boolean invalide = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalide = false;
            } catch (ArrayIndexOutOfBoundsException indexOfEx) {
                System.out.println("Enter number menu  of range");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
            }
        }
        while (invalide);
        return value;
    }

}
