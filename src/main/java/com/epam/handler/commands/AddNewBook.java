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
public class AddNewBook implements IHandler {
    public void handle(Request request, Response response) throws IOException {
        response(request, response);
    }

    private void response(Request request, Response response) throws IOException {
        new Library();
        Book book = new Book(5, "dfd", "dfdf", 43);

        try {
            response.setBody(String.valueOf(book));
            Library.addBook(book);
            response.write();

            System.out.println("New book " + book);
        } catch (IOException e) {
            response.writeErrorResponse();
        }

    }
}
