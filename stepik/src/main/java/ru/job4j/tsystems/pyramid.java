package ru.job4j.tsystems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class pyramid {

    public void build(List<Integer> list) {
        Collections.sort(list);
        int rows = this.calcRow(list);
        int column = this.calcColumn(rows);
        int[][] mas = new int[rows][column];
        this.fillMatrix(mas, list);


        int p = 0;
    }

    private void fillMatrix(int[][] mas, List<Integer> list) {
        int countZero = 0;
        int s = mas.length;
        int indentLeft = 0;
        int indentRight = 0;
        int indexList = list.size() - 1;
        for (int i = mas.length - 1; i >= 0; i--) {

            for (int j = mas[i].length - 1 - indentLeft; j >= indentLeft; j--) {


                //int ppp = list.get(indexList--);
                int sd = 0;
            }
            indentLeft++;

        }

        int p = 0;


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
        return rows - 1;
    }


    private void print(int[][] array) {

    }


    public static void main(String[] args) {
       // new pyramid().build(new ArrayList<>(Arrays.asList(1, 2, 3)));
        new pyramid().build(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        new pyramid().build(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
//         new pyramid().build(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));

    }
}
