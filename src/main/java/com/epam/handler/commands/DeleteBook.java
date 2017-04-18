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
public class DeleteBook implements IHandler {

    public void handle(Request request, Response response) throws IOException {
        response(request, response);
    }

    private void response(Request request, Response response) throws IOException {

        Book deletedBook;
        try {

            deletedBook = JsonUtils.fromJson(request.getBody(), Book.class);
            Library.deleteBook(deletedBook);
            response.setStatusCode(Constants.STATUS_CODE_200_OK);
            System.out.println("Deleted book " + deletedBook);

        } catch (Exception e) {
            response.setStatusCode(Constants.STATUS_CODE_404);
        }
        response.createResponse(response, request);




    }
}
