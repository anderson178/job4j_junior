package ru.job4j.tsystems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsequence {

    public void find(List<String> first, List<String> second) {
        List<String> rst = new ArrayList<>();
        for (String symbolFirst : first) {
            char[] masSymbolsFirst = symbolFirst.toCharArray();
            for (String symbolSecond : second) {
                char[] masSymbolsSecond = symbolSecond.toCharArray();

                if (compare(masSymbolsFirst, masSymbolsSecond)) {
                    rst.add(symbolSecond);
                } else {
                    break;
                }


            }
        }
        int p = 0;

    }

    private boolean compare(char[] masSymbolsFirst, char[] masSymbolsSecond) {
        boolean rst = true;
        if (masSymbolsFirst.length == masSymbolsSecond.length) {
            int count = 0;
            for (int i = 0; i < masSymbolsFirst.length; i++) {
                if (masSymbolsFirst[i] == masSymbolsSecond[i]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count != masSymbolsFirst.length) {
                rst = false;
            }

        }
        return rst;
    }


    public static void main(String[] args) {
        new Subsequence().find(new ArrayList<>(Arrays.asList("a", "b", "c", "d")),
                new ArrayList<>(Arrays.asList("bd", "a", "n", "b", "dc", "c", "a", "d")));
    }


}
