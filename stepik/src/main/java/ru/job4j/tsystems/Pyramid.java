package ru.job4j.tsystems;

import java.util.Collections;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.09.2019
 */
public class Pyramid {
    private final static String LN = System.lineSeparator();

    /**
     * The method build a triangle of numbers in a matrix
     *
     * @param list
     * @return
     */
    public int[][] build(List<Integer> list) {
        Collections.sort(list);
        int rows = this.calcRows(list);
        int[][] mas = new int[this.calcRows(list)][this.calcColumns(rows)];
        return this.fillMatrix(mas, list);
    }

    /**
     * Method for fill the matrix
     *
     * @param mas  - input array
     * @param list - input a list with numbers
     * @return - fill array
     */
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

    /**
     * Method to calculate count a columns of the matrix
     *
     * @param rows - count rows
     * @return
     */
    private int calcColumns(int rows) {
        int columns = 1;
        for (int i = 0; i < rows - 1; i++) {
            columns = columns + 2;
        }
        return columns;
    }

    /**
     * Method to calculate count a rows of the matrix
     *
     * @param list - input list with numbers
     * @return - count rows
     */
    private int calcRows(List<Integer> list) {
        int size = list.size();
        int rows = 1;
        int count = 0;
        while (count < size) {
            count = count + rows;
            rows++;
        }
        if (size != count) {
            throw new IllegalArgumentException("Impossible to build a triangle");
        }
        return rows - 1;
    }
}
