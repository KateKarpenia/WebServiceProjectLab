package com.epam;

import com.epam.actions.Request;
import com.epam.actions.Response;
import com.epam.handler.Handler;

import java.io.*;
import java.net.Socket;


/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class SocketProcessor implements Runnable {

    private Socket socket;
    private Request request;
    private Response response;
    private InputStream inputStream;
    private OutputStream outputStream;

    public SocketProcessor(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            request = new Request(new BufferedReader(new InputStreamReader(socket.getInputStream())));
            System.out.println(request.toString());
            response = new Response(outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Handler currentHandler = HttpServer.chooseHandler(request);
            currentHandler.getiHandler().handle(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Client processing finished");

    }
}
