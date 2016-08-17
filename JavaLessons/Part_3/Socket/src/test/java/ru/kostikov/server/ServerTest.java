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
        Server server = new Server(500);

        server.start();

        Client client = new Client(5000, "127.0.0.1");

        client.start();
    }


}