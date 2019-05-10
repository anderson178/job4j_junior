package ru.job4j.io.socket;

import com.google.common.base.Joiner;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.04.2019
 */

public class SocketClientTest {
    private static final String LN = System.lineSeparator();


    @Test
    public void whenHelloAndExit() throws IOException {
        this.testClient(Joiner.on(LN).join("hello", "exit"),
                Joiner.on(LN).join("Hello, dear friend, I'm a oracle.", LN),
                Joiner.on(LN).join("Connection established", "hello",
                        "Hello, dear friend, I'm a oracle.", "exit", "Connection broken" + LN));
    }

    @Test
    public void whenExit() throws IOException {
        this.testClient("exit", "",
                Joiner.on(LN).join("Connection established", "exit", "Connection broken" + LN));
    }

    /**
     * Базовый метод проверки клиенсткой части бота.
     *
     * @param inputClient - входящий набор строк для передачи на сервер
     * @param answerServ  - ответ от сервер
     * @param expected    - ожидаемый результат
     * @throws IOException
     */

    private void testClient(String inputClient, String answerServ, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(answerServ.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.setIn(new ByteArrayInputStream(inputClient.getBytes()));
        when(socket.getOutputStream()).thenReturn(out);
        when(socket.getInputStream()).thenReturn(in);
        new Client(socket).startClient();
        assertThat(out.toString(), is(expected));
    }
}
