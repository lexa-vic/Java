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

    /** Порт сокета */
    private int socketPort;

    /**
     * Установка порта для сокета
     * @param port
     */
    public void setSocketPort(int port){
        this.socketPort = port;
    }

    /**
     *  Запуск сервера
     */
    public void start(){
        try{
            ServerSocket serverSocket = new ServerSocket(this.socketPort);

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
        Server server = new Server();
        server.setSocketPort(5000);
        server.start();
    }
}
