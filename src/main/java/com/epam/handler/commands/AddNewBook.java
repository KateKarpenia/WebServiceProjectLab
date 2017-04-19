package com.epam.handler.commands;

import com.epam.actions.Request;
import com.epam.actions.Response;
import com.epam.entity.Book;
import com.epam.entity.Library;
import com.epam.handler.IHandler;
import com.epam.utils.Constants;
import com.epam.utils.JsonUtils;

import java.io.IOException;

/**
 * Created by Katerina_Karpenia on 4/17/2017.
 */
public class AddNewBook implements IHandler {
    public void handle(Request request, Response response) throws IOException {
        response(request, response);
    }

    private void response(Request request, Response response) throws IOException {

        String body = " ";
        String contentType = request.validateContentType(request.getContentType());
        new Library();
        Book newBook = new Book(4, "Herbert Schildt ", "Java 1.1: The Complete Reference", 345);
        Library.addBook(newBook);

        try {
            body = JsonUtils.toJson(newBook);
            response.setStatusCode(Constants.STATUS_CODE_201);
        } catch (Exception e) {
            response.setStatusCode(Constants.STATUS_CODE_400);
        }

        response.setContentType(contentType);
        response.setContentLength(String.valueOf(body.getBytes().length));
        response.setBody(body);
        response.setVersion(request.getVersion());
        response.write();
        System.out.println(response.toString());

    }
}
