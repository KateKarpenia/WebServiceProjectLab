package com.epam;

import com.epam.actions.Request;
import com.epam.handler.Handler;
import com.epam.handler.IHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class HttpServer {

    private int port;
    private final static List<Handler> handlers = new ArrayList<Handler>();

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

    public static Handler chooseHandler(Request rq) throws IOException {

        String methodFromRequest = rq.getMethod();
        String pathFromRequest = rq.getPath();

        for (Handler handler : handlers) {
            if (methodFromRequest.equals(handler.getMethod()) && handler.getUri().contains(pathFromRequest)) {
                return handler;
            }
        }
        return null;
    }


    public void invokeHandler(String method, String uri, IHandler iHandler) {
        handlers.add(new Handler(method, uri, iHandler));
    }

}
