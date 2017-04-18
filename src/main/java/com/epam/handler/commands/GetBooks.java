package com.epam.handler.commands;

import com.epam.actions.Request;
import com.epam.actions.Response;
import com.epam.entity.Book;
import com.epam.entity.Library;
import com.epam.handler.IHandler;
import com.epam.utils.Constants;
import com.epam.utils.JsonUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by Katerina_Karpenia on 4/17/2017.
 */
public class GetBooks implements IHandler {

    public void handle(Request request, Response response) throws IOException {
        response(request, response);
    }

    private void response(Request request, Response response) throws IOException {

        String body = " ";
        String contentType = request.validateContentType(request.getContentType());
        new Library();
        List<Book> books = Library.getBooks();

        try {
            body = JsonUtils.toJson(books);
            response.setStatusCode(Constants.STATUS_CODE_200_OK);
        } catch (Exception e) {
            response.setStatusCode(Constants.STATUS_CODE_404);
        }

        response.setContentType(contentType);
        response.setContentLength(String.valueOf(body.getBytes().length));
        response.setBody(body);
        response.setVersion(request.getVersion());
        response.write();

    }

}
