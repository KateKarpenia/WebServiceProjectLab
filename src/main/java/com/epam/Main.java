package com.epam;


import com.epam.handler.AddNewBook;
import com.epam.handler.DeleteBook;
import com.epam.handler.GetBooks;
import com.epam.handler.UpdateBook;
import com.epam.utils.Constants;

import java.io.IOException;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        HttpServer httpServer = new HttpServer(8085);

        httpServer.invokeHandler("GET", Constants.GET_BOOKS, new GetBooks());
        httpServer.invokeHandler("POST", Constants.ADD_NEW_BOOK, new AddNewBook());
        httpServer.invokeHandler("DELETE", Constants.DELETE_BOOK, new DeleteBook());
        httpServer.invokeHandler("PUT", Constants.UPDATE_BOOK, new UpdateBook());

        httpServer.start();

    }

}
