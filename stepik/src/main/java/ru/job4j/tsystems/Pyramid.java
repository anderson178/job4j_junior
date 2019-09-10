package ru.job4j.tsystems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pyramid {
    private final static String LN = System.lineSeparator();

    public int[][] build(List<Integer> list) {
        Collections.sort(list);
        int rows = this.calcRow(list);
        int[][] mas = new int[this.calcRow(list)][this.calcColumn(rows)];
        return this.fillMatrix(mas, list);
    }

    private int[][] fillMatrix(int[][] mas, List<Integer> list) {
        int indent = 0;
        int index = list.size() - 1;
        for (int i = mas.length - 1; i >= 0; i--) {
            boolean flag = true;
            for (int j = mas[i].length - 1 - indent; j >= indent; j--) {
                if (flag) {
                    mas[i][j] = list.get(index--);
                    flag = false;
                } else {
                    flag = true;
                }
            }
            indent++;
        }
        return mas;
    }


    private int calcColumn(int row) {
        int column = 1;
        for (int i = 0; i < row - 1; i++) {
            column = column + 2;
        }
        return column;
    }

    private int calcRow(List<Integer> list) {
        int size = list.size();
        int rows = 1;
        int count = 0;
        while (count < size) {
            count = count + rows;
            rows++;
        }
        if (size != count) {
            //TODO throw
            System.out.println("no");
            int p = 0;
        }
        return rows - 1;
    }


    public static void main(String[] args) {
        int[][] p = new Pyramid().build(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        int sd = 0;

    }
}
