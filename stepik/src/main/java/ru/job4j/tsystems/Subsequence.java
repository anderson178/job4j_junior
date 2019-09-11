package ru.job4j.tsystems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 11.09.2019
 */
public class Subsequence {

    /**
     * The method checks whether it is possible to build the first from the second list
     *
     * @param first  - first list
     * @param second - second list
     * @return if are can then return true otherwise false
     */
    public boolean find(List<String> first, List<String> second) {
        boolean rst = false;
        List<String> temp = new ArrayList<>();
        int pointerIndex = 0;
        if (first.size() <= second.size()) {
            for (String symbolFirst : first) {
                char[] masSymbolsFirst = symbolFirst.toCharArray();
                for (int i = pointerIndex; i < second.size(); i++) {
                    pointerIndex++;
                    char[] masSymbolsSecond = second.get(i).toCharArray();
                    if (compare(masSymbolsFirst, masSymbolsSecond)) {
                        temp.add(second.get(i));
                        break;
                    }
                }
                if (first.size() == temp.size()) {
                    rst = true;
                    break;
                }
            }
        }
        return rst;
    }

    /**
     * The method checks if two arrays are equal to each other
     *
     * @param masSymbolsFirst  - first array
     * @param masSymbolsSecond - second array
     * @return - if arrays are equal then return true otherwise false
     */
    private boolean compare(char[] masSymbolsFirst, char[] masSymbolsSecond) {
        boolean rst = false;
        if (masSymbolsFirst.length == masSymbolsSecond.length) {
            int count = 0;
            for (int i = 0; i < masSymbolsFirst.length; i++) {
                if (masSymbolsFirst[i] == masSymbolsSecond[i]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == masSymbolsFirst.length) {
                rst = true;
            }
        }
        return rst;
    }
}
