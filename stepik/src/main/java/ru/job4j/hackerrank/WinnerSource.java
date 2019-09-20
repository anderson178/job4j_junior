package ru.job4j.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinnerSource {

    public static String winner(String erica, String bob) {

//        int p = calcSource(erica);
//        int i = calcSource(bob);
//
//        System.out.println(erica);
//        System.out.println(bob);

        return calcSource(erica) > calcSource(bob) ? erica : bob;
        // Write your code here

    }

    public static int calcSource(String line) {
        int rst = 0;
        char[] temp = line.toCharArray();
        for (char symbol : temp) {
            if (symbol == 'E') {
                rst = rst + 1;
            } else if (symbol == 'M') {
                rst = rst + 3;
            } else if (symbol == 'H') {
                rst = rst + 5;
            }
        }
        return rst;
    }

    public static int fountainActivation(List<Integer> a) {
        int rst = 0;
        for (int i = 1; i < a.size(); i++) {
            rst = rst + a.get(i);
        }
        int r = a.get(0) / rst;
        return r;
        // Write your code here

    }

    public static void main(String[] args) {
        fountainActivation(new ArrayList<>(Arrays.asList(3, 1, 1, 1)));
        String tt = WinnerSource.winner("EMH", "EHH");
        int p = 0;
    }
}
