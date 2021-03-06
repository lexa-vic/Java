package ru.kostikov.server;

import com.google.common.base.Joiner;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import ru.kostikov.client.Client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Created by Алексей on 16.08.2016.
 */
public class ServerTest {

    @Test
    public void start() throws Exception {
        String questions = Joiner.on("").join("Привет\r\n","я тут\r\n", "закончить\r\n");
        int questionCnt = 3;
        int responseCnt = 0;
        String encoding = "UTF-8";

        // Создаем mock'и
        ServerSocket serverSocket  = mock(ServerSocket.class);
        Socket socket  = mock(Socket.class);
        Server server = new Server(serverSocket);

        // Когда сервер вызовет создание сокета, подсовываем mock
        when(serverSocket.accept()).thenReturn(socket);

        // А в самом сокете модменяем на входной и выходной потоки
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        InputStream inputStream = new ByteArrayInputStream(questions.getBytes(encoding));
        when(socket.getInputStream()).thenReturn(inputStream);

        server.start();

        Scanner scan = new Scanner(byteArrayOutputStream.toString());
        // Считаем кол-во отправленных строк ответов
        while(scan.hasNextLine()){
            scan.nextLine();
            responseCnt++;
        }
        // На каждый запрос сервер отвечает, т.е. кол-во запросов и ответов равны
        assertThat(questionCnt,  is(responseCnt));
    }


}