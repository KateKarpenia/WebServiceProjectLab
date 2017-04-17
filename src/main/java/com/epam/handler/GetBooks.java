package com.epam.handler;

import com.epam.actions.Request;
import com.epam.actions.Response;
import com.epam.entity.Book;
import com.epam.entity.Library;

import java.io.IOException;
import java.util.List;

/**
 * Created by Katerina_Karpenia on 4/17/2017.
 */
public class GetBooks implements IHandler{

    public void handle(Request request, Response response) throws IOException {
        response(request, response);
    }

    private void response(Request request, Response response) {
        List<Book> books = Library.getBooks();
        String bookList = books.toString();
        try {
            response.setBody(bookList);
            response.write();

            System.out.println("GetBooks " + books);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
