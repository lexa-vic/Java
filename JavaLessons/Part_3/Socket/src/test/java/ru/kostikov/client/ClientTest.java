package ru.kostikov.client;

import com.google.common.base.Joiner;
import org.junit.Test;
import ru.kostikov.server.Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Алексей on 20.08.2016.
 */
public class ClientTest {
    @Test
    public void start() throws Exception {
        String clientQuestions = Joiner.on("").join("Привет\r\n","я тут\r\n", "закончить\r\n");
        String serverResponse = Joiner.on("").join("1\r\n","2\r\n", "3\r\n");
        int questionCnt = 3;
        int responseCnt = 0;
        String encoding = "UTF-8";

        // Создаем mock'и
        Socket socket  = mock(Socket.class);

        InputStream clientInputStream = new ByteArrayInputStream(clientQuestions.getBytes(encoding));
        InputStream inputStreamFromServer = new ByteArrayInputStream(serverResponse.getBytes(encoding));

        when(socket.getInputStream()).thenReturn(inputStreamFromServer);
        // Подсовываем mock клиенту
        Client client = new Client(socket, clientInputStream);

        // А в самом сокете модменяем на входной и выходной потоки
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        client.start();

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