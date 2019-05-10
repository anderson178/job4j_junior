package ru.job4j.io.socket;


import ru.job4j.io.chat.Input;

import java.io.*;
import java.net.*;
import java.util.Scanner;


/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.04.2019
 */

public class Client {
    private final static int PORT = 10000;
    private final static String IP = "127.0.0.1";
    private final Socket socket;
    private static final String EXIT = "exit";
    private String outLine;
    private String inLine;
    private Scanner scanner = new Scanner(System.in);

    public Client(Socket socket) {
        this.socket = socket;
    }

    /**
     * Метод берет у севверного сокета входящий и исходящий поток.
     * Згружает набор байт в выходной поток, далее считывает вхожной поток.
     * В случае набора команды "exit" выполнится завершение программы.
     *
     * @throws IOException
     */
    public void startClient() throws IOException {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Connection established");
            this.outLine = scanner.nextLine();
            while (!this.outLine.equalsIgnoreCase(EXIT)) {
                out.println(this.outLine);
                this.inLine = in.readLine();
                while (!inLine.isEmpty()) {
                    System.out.println(this.inLine);
                    this.inLine = in.readLine();
                }
                this.outLine = scanner.nextLine();
            }
            out.println(this.outLine);
            System.out.println("Connection broken");
        }
    }

    /**
     * Метод создает сокет с подключением к серверу
     *
     * @param args - не требуется
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (final Socket socket = new Socket(InetAddress.getByName(IP), PORT);) {
            new Client(socket).startClient();
        }
    }


}
