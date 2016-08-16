package ru.kostikov.server;

import ru.kostikov.chat.Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Алексей on 13.08.2016.
 */
public class Server {

    public static void main(String[] args) {
        /** Порт для сокета */
        int port = 5000;

        try{
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Ждем подключения к серверу");
            Socket socket = serverSocket.accept();
            System.out.println("Подключение состоялось");

            InputStream socketInpStream = socket.getInputStream();
            OutputStream socketOutStream = socket.getOutputStream();

            Reader reader = new InputStreamReader(socketInpStream);
            Writer writer = new OutputStreamWriter(socketOutStream);

            DataOutputStream out = new DataOutputStream(socketOutStream);
            DataInputStream in = new DataInputStream(socketInpStream);


            String string = null;
            Chat chat = null;

            try {
                chat = new Chat(reader,
                                writer,
                                new FileReader("JavaLessons\\Part 3\\IO\\5. Chat\\answers.txt"));
                chat.run();
            } catch (FileNotFoundException e) {

                System.out.println("Файл c ответами не найден");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
