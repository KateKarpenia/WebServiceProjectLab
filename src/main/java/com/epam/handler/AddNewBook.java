package com.epam.handler;

import com.epam.actions.Request;
import com.epam.actions.Response;
import com.epam.entity.Book;
import com.epam.entity.Library;

import java.io.IOException;

/**
 * Created by Katerina_Karpenia on 4/17/2017.
 */
public class AddNewBook implements IHandler {
    public void handle(Request request, Response response) throws IOException {
        response(request, response);
    }

    private void response(Request request, Response response) {
        Book book = new Book(5, "dfd", "dfdf", 43);
//        Library.addBook(book);

        try {
            response.setBody(String.valueOf(book));
            Library.addBook(book);
            Library.getBooks();
            response.write();

            System.out.println("New book " + book);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
