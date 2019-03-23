package ru.job4j.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 24.03.2019
 */
public class ByteStream {

    /**
     * Метод проверяет на четность число находящееся в байтовом потоке
     *
     * @param in - входящий байтовый поток
     * @return - четное/нечетное true/false
     * @throws IOException
     */
    public boolean isNumber(InputStream in) throws IOException {
        byte[] array = in.readAllBytes();
        return array.length > 0 && array[array.length - 1] % 2 == 0;
    }


}
