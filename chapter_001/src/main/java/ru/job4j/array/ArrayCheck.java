package ru.job4j.array;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 09.08.2018
 */

public class ArrayCheck {
    /**
     *
     * @param word - входящее слово.
     * @param checkSymbols - символы которые необходимо проверить.
     * @return - если проверочне символы совпадают с символами в слоке то вернет true иначе false.
     * (i < arrayCheckSymbols.length) & (i < arrayWordSymbols.length) - проверяются оба условия так как может
     * одно слово быть больше друго и наоборот (исключение ошибок человечекого фактора), что бы не выйти за границы
     * массивов.
     */
    public boolean checkWord(String word, String checkSymbols) {
        boolean result = true;
        char[] wordArray = word.toCharArray();
        char[] checkArray = checkSymbols.toCharArray();
        for (int i = 0; (i < checkArray.length) & (i < wordArray.length); i++) {
            if (wordArray[i] != checkArray[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
