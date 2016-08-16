package ru.kostikov.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import org.apache.log4j.Logger;


/**
 * Created by Алексей on 13.08.2016.
 */
public class Client {

    /** Логгер*/
    private static final Logger log = Logger.getLogger(Client.class);

    /** Порт сокета */
    private int socketPort;

    /** Ip адрес сервера */
    private String addr = "127.0.0.1";

    /**
     * Установка порта для сокета
     * @param port
     */
    public void setSocketPort(int port){
        this.socketPort = port;
    }

    /**
     *  Установка Ip адреса сервера
     * @param addr Ip адрес в формате String
     */
    public void setServerIpAddr(String addr){
        this.addr = addr;
    }

    /**
     *  Запуск клиента
     */
    public void start(){
        try {
            InetAddress inetAddress = InetAddress.getByName(this.addr);

            System.out.println("Подключаемся к серверу");
            Socket socket = new Socket(inetAddress, this.socketPort);

            InputStream socketInpStream = socket.getInputStream();
            OutputStream socketOutStream = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Writer serverWriter = new OutputStreamWriter(socketOutStream);

            String string = null;
            String  response = null;
            Scanner scanner = new Scanner(socketInpStream);

            System.out.println("Введите строку: ");

            while (true){
                string = reader.readLine();

                serverWriter.write(string+"\r\n");
                serverWriter.flush();

                log.debug(string);

                response = scanner.nextLine();
                System.out.println("Сервер прислал: "+ response);
                log.debug(response);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();

        client.setSocketPort(5000);
        client.setServerIpAddr("127.0.0.1");
        client.start();
    }

}
