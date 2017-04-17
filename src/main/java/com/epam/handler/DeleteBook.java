package com.epam.handler;

import com.epam.actions.Request;
import com.epam.actions.Response;
import com.epam.entity.Book;
import com.epam.entity.Library;
import com.epam.utils.JsonUtils;

import java.io.IOException;

/**
 * Created by Katerina_Karpenia on 4/17/2017.
 */
public class DeleteBook implements IHandler{

    public void handle(Request request, Response response) throws IOException {
        response(request, response);
    }

    private void response(Request request, Response response) throws IOException {

        Book deletedBook;
        try {
            deletedBook = JsonUtils.fromJson(request.getBody(), Book.class);
            System.out.println("deleted book " + deletedBook);
            Library.deleteBook(deletedBook);
            response.write();
        } catch (Exception e) {
            response.writeErrorResponse();
        }
    }
}
