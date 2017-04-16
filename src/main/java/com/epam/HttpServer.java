package com.epam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class HttpServer {

    private int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client accepted");
            new Thread(new SocketProcessor(socket)).start();
        }

    }

}
