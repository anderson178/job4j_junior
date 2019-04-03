package ru.job4j.io.chat;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.04.2019
 */

public class ChatUI {
    Input input;
    private static final String SR = File.separator;
    private final static String ROOTDIR = System.getProperty("java.io.tmpdir") + SR + "chapter_002_IO";
    private final static String PATHLOG = ROOTDIR + SR + "log.txt";
    private final static String PATHVOCABILARY = ROOTDIR + SR + "vocabulary.txt";
    private String vocabilary;
    private List<String> words;
    private Action action;

    public ChatUI(Input input, Action action, String vocabilary) {
        this.input = input;
        this.vocabilary = vocabilary;
        this.action = action;
    }

    /**
     * Метод запрашивает ввод данных до тех пор пока не будет строки "continue",
     * записвая все действия в файл (лог)
     * @param ask - ответ пользователя
     * @throws IOException
     */
    private void stop(String ask) throws IOException {
        do {
            action.writeFile("Human", ask, PATHLOG);
            ask = input.ask();
        } while (!ask.equals("continue"));
        action.writeFile("Human", ask, PATHLOG);
        dialog();
    }

    /**
     * Метод проверяет ответ пользователя на наличие заданных слов, исходя из них выполняет определенную логику.
     * Все действия записываются в файл (лог)
     * Метод является рекурсивным.
     * @throws IOException
     */
    public void dialog() throws IOException {
        String ask = input.ask();
        if (!ask.equals("finish")) {
            if (ask.equals("stop")) {
                stop(ask);
            } else {
                action.writeFile("Human", ask, PATHLOG);
                action.writeFile("Bot", action.getWord(words), PATHLOG);
                dialog();
            }
        } else {
            action.writeFile("Human", "finish", PATHLOG);
        }
    }

    /**
     * Метод выполняет подготовительные действия по формровании директорий и файлов для обработки команд чата
     * @throws IOException
     */
    public void init() throws IOException {
        action.removeDir(ROOTDIR);
        action.createDir(ROOTDIR);
        action.writeFile(PATHVOCABILARY, vocabilary);
        words = action.fillWords(PATHVOCABILARY);
        dialog();
    }
}
