package ru.job4j.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.stream.IntStream;

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
        byte[] streamByte = in.readAllBytes();
        return this.existStringSymbol(new String(streamByte).toCharArray()).isEmpty()
                && (streamByte[streamByte.length - 1] % 2 == 0);
    }

    /**
     * метод проверяет элементы массива на предмет появления строкового символа
     * @param line - массив с символами
     * @return - optional
     */
    private Optional existStringSymbol(char[] line) {
        return IntStream.range(0, line.length).mapToObj(i-> line[i])
                .filter(symbol -> !Character.isDigit(symbol)).findAny();
    }
}
