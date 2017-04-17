package com.epam.handler.commands;

import com.epam.actions.Request;
import com.epam.actions.Response;
import com.epam.entity.Book;
import com.epam.entity.Library;
import com.epam.handler.IHandler;

import java.io.IOException;

/**
 * Created by Katerina_Karpenia on 4/17/2017.
 */
public class GetCurrentBook implements IHandler {
    public void handle(Request request, Response response) throws IOException {
        response(request, response);
    }

    private void response(Request request, Response response) {

        Book book = Library.getCurrentBook(1);
        String currentBook = book.toString();
        try {
            response.setBody(currentBook);
            response.write();
            System.out.println("GetBook " + currentBook);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
