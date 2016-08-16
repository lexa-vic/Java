package ru.kostikov.server;

import org.junit.Test;
import ru.kostikov.client.Client;

import static org.junit.Assert.*;

/**
 * Created by Алексей on 16.08.2016.
 */
public class ServerTest {
    @Test
    public void start() throws Exception {
        Server server = new Server();
        server.setSocketPort(5000);

        server.start();

        Client client = new Client();

        client.setSocketPort(5000);
        client.setServerIpAddr("127.0.0.1");

        client.start();
    }


}