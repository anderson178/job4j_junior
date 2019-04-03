package ru.job4j.io.chat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.04.2019
 */

public class ChatUITest {
    private static final String SR = File.separator;
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String LN = System.lineSeparator();


    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }


    @Test
    public void whenTestChat() throws IOException {
        String vocabilary = "hi fine you men";
        Input input = new StubInput(new ArrayList<>(Arrays.asList("hi chat", "how are you", "nothing", "finish")));
        Action action = new StubAction();
        new ChatUI(input, action, vocabilary).init();
        assertThat(new String(out.toByteArray()), is(new StringBuffer()
                .append("hi chat")
                .append(LN)
                .append("hi")
                .append(LN)
                .append("how are you")
                .append(LN)
                .append("fine")
                .append(LN)
                .append("nothing")
                .append(LN)
                .append("you")
                .append(LN)
                .append("finish")
                .append(LN)
                .toString()
        ));
    }

    @Test
    public void whenTestLog() throws IOException {
        String pathLog = System.getProperty("java.io.tmpdir") + SR + "chapter_002_IO" + SR + "log.txt";
        String vocabilary = "hi fine you men";
        Input input = new StubInput(new ArrayList<>(Arrays.asList("hi chat", "how are you", "nothing", "finish")));
        Action action = new StubAction();
        new ChatUI(input, action, vocabilary).init();
        List<String> rst = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(pathLog)))) {
            while (scanner.hasNextLine()) {
                rst.add(scanner.nextLine());
            }
        }
        List<String> expected = new ArrayList<>(Arrays.asList("Human - hi chat", "Bot - hi", "Human - how are you",
                "Bot - fine", "Human - nothing", "Bot - you", "Human - finish"));
        assertThat(rst, is(expected));
    }


    @Test
    public void whenStopChat() throws IOException {
        String vocabilary = "hi fine you men";
        Input input = new StubInput(new ArrayList<>(Arrays.asList("hi chat", "stop", "one", "two", "continue",
                "nothing", "finish")));
        Action action = new StubAction();
        new ChatUI(input, action, vocabilary).init();
        assertThat(new String(out.toByteArray()), is(new StringBuffer()
                .append("hi chat")
                .append(LN)
                .append("hi")
                .append(LN)
                .append("stop")
                .append(LN)
                .append("one")
                .append(LN)
                .append("two")
                .append(LN)
                .append("continue")
                .append(LN)
                .append("nothing")
                .append(LN)
                .append("fine")
                .append(LN)
                .append("finish")
                .append(LN)
                .toString()
        ));
    }

    @Test
    public void whenStopLog() throws IOException {
        String pathLog = System.getProperty("java.io.tmpdir") + SR + "chapter_002_IO" + SR + "log.txt";
        String vocabilary = "hi fine you men";
        Input input = new StubInput(new ArrayList<>(Arrays.asList("hi chat", "stop", "one", "two", "continue",
                "nothing", "finish")));
        Action action = new StubAction();
        new ChatUI(input, action, vocabilary).init();
        List<String> rst = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(pathLog)))) {
            while (scanner.hasNextLine()) {
                rst.add(scanner.nextLine());
            }
        }
        List<String> expected = new ArrayList<>(Arrays.asList("Human - hi chat", "Bot - hi", "Human - stop",
                "Human - one", "Human - two", "Human - continue", "Human - nothing", "Bot - fine", "Human - finish"));
        assertThat(rst, is(expected));
    }


}
