package com.epam;

import com.epam.actions.Request;
import com.epam.actions.Response;
import com.epam.entity.Library;
import com.epam.utils.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    private String uri;
    private String method;

    public SocketProcessor(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            request = new Request(inputStream);
            request.parse();
            uri = request.getUri();
            method = request.getMethod();

            response = new Response(outputStream);
            response.setRequest(request);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (method.startsWith(Constants.GET) && uri.endsWith(Constants.GET_BOOKS)) {
                response.writeResponseLibrary(Library.getBooks());
            } else if (method.startsWith(Constants.GET) && uri.endsWith(Constants.GET_CURRENT_BOOK1)) {
                response.writeResponseBook(Library.getCurrentBook(1));
            } else if (method.startsWith(Constants.GET) && uri.endsWith(Constants.GET_CURRENT_BOOK2)) {
                response.writeResponseBook(Library.getCurrentBook(2));
            } else if (method.startsWith(Constants.GET) && uri.endsWith(Constants.WELCOME_PAGE)) {
                response.writeResponse();
            }
            else {
                response.writeErrorResponse();
            }

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
