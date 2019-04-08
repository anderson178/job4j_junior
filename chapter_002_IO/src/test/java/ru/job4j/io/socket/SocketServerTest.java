package ru.job4j.io.socket;

import com.google.common.base.Joiner;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.04.2019
 */

public class SocketServerTest {
    private static final String LN = System.lineSeparator();
    private List<String> phraseServ = new ArrayList<>();


    @Before
    public void setUp() {
        phraseServ.add("Суть жизни – найти самого себя.");
        phraseServ.add("В диалоге с жизнью важен не ее вопрос, а наш ответ.");
        phraseServ.add("У любого «нет» всегда есть шанс стать «может быть».");
    }


    @Test
    public void whenCheckExit() throws IOException {
        this.testServer("exit", "");
    }

    @Test
    public void whenAnswerThreePharseandExit() throws IOException {
        StringBuffer expected = new StringBuffer();
        expected.append(this.phraseServ.get(0) + LN);
        expected.append(LN);
        expected.append(this.phraseServ.get(1) + LN);
        expected.append(LN);
        expected.append(this.phraseServ.get(2) + LN);
        expected.append(LN);
        this.testServer(Joiner.on(LN).join("Поведай мне что нибудь", "а еще", "и еще", "exit"),
                expected.toString());
    }

    @Test
    public void whenAskHelloandExit() throws IOException {
        this.testServer(Joiner.on(LN).join("Hello", "exit"), "Hello, dear friend, I'm a oracle."
                + LN + LN);
    }

    /**
     * Базовый метод проверки серверной части бота
     *
     * @param input    - входящий набор строк от клиента
     * @param expected - ожидаемый результат
     * @throws IOException
     */
    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        new Server(socket, new StubOutput(this.phraseServ)).startServer();
        assertThat(out.toString(), is(expected));
    }
}
