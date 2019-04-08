package ru.job4j.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.04.2019
 */

public class Server {
    private final static int PORT = 10000;
    private static final String EXIT = "exit";
    private final Socket socket;
    private Output output;
    private String ask;
    private static List<String> phraseSet = new ArrayList<>();
    private static final String LN = System.lineSeparator();

    public Server(Socket socket, Output output) {
        this.output = output;
        this.socket = socket;
    }

    /**
     * Метод берет у севверного сокета входящий и исходящий поток.
     * Считывает входной поток, после чего выполняет логику и загружает набор байт в выходной поток.
     *
     * @throws IOException
     */

    public void startServer() throws IOException {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            this.fillPhraseSet();
            this.ask = in.readLine();
            while (!this.ask.equalsIgnoreCase("exit")) {
                System.out.println("Client is write: " + this.ask);
                if (this.ask.equalsIgnoreCase("hello")) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                } else {
                    for (String answer : output.answer()) {
                        out.println(answer);
                    }
                    out.println();
                }
                this.ask = in.readLine();
            }
            System.out.println("Server disconnetcion");
        }
    }

    /**
     * Метод заполняет список набором фраз которые будут возвращаться клиенту.
     */
    private void fillPhraseSet() {
        phraseSet.add("Суть жизни – найти самого себя.");
        phraseSet.add("В диалоге с жизнью важен не ее вопрос, а наш ответ.");
        phraseSet.add("У любого «нет» всегда есть шанс стать «может быть».");
        phraseSet.add("Время лечит всех. Только никто не выжил.");
        phraseSet.add("от взлета до падения только миг...");
    }

    /**
     * Метод создает серверный сокет и ожидает подключение клиента
     *
     * @param args - не требуется
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (final Socket socket = new ServerSocket(PORT).accept()) {
            System.out.println("Client is connection");
            new Server(socket, new StubOutput(phraseSet)).startServer();
        }

    }


}
