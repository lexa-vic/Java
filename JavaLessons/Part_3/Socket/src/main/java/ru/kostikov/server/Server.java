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

    /** Сокет сервера */
    private ServerSocket serverSocket;

    /**
     * Конструктор
     * @param serverSocket соединения
     */
    public Server(ServerSocket serverSocket){

        this.serverSocket = serverSocket;
    }

    /**
     *  Запуск сервера
     */
    public void start(){
        try{

            System.out.println("Ждем подключения к серверу");
            Socket socket = this.serverSocket.accept();
            System.out.println("Подключение состоялось");

            InputStream socketInpStream = socket.getInputStream();
            OutputStream socketOutStream = socket.getOutputStream();

            Reader reader = new InputStreamReader(socketInpStream);
            Writer writer = new OutputStreamWriter(socketOutStream);

            Chat chat = null;
            try {
                String url = Chat.class.getClassLoader().getResource("answers.txt").getFile();

                chat = new Chat(reader,
                                writer,
                                new FileReader(new File(url)));
                chat.run();
            } catch (FileNotFoundException e) {
                System.out.println("Файл c ответами не найден");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = null;
        try {
            server = new Server(new ServerSocket(5000));
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
