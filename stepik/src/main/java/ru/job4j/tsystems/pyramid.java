package ru.job4j.tsystems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class pyramid {

    public void build(List<Integer> list) {
        Collections.sort(list);
        int column = this.calcHeight(list);
        int row = this.calcWeight(column);
        int[][] array = new int[row][column];

        int p = 0;
    }

    private int calcWeight(int height) {
        int weight = 1;
        for (int i = 0; i < height - 1; i++) {
            weight = weight + 2;

        }
        return weight;
    }

    private int calcHeight(List<Integer> list) {
        int height = 0;
        int size = list.size();
        for (int i = 1; i < list.size() + 1 && size > 0; i++) {
            size = size - i;
            height++;
        }
        return height;
    }


    private void print(int[][] array) {

    }


    public static void main(String[] args) {
        new pyramid().build(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
//         new pyramid().build(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));

    }
}
