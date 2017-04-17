package com.epam;


import com.epam.handler.commands.*;
import com.epam.utils.Constants;

import java.io.IOException;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        HttpServer httpServer = new HttpServer(8085);

        httpServer.invokeHandler("GET", Constants.GET_BOOKS, new GetBooks());
        httpServer.invokeHandler("GET", Constants.GET_CURRENT_BOOK1, new GetCurrentBook());
        httpServer.invokeHandler("POST", Constants.ADD_NEW_BOOK, new AddNewBook());
        httpServer.invokeHandler("DELETE", Constants.DELETE_BOOK, new DeleteBook());
        httpServer.invokeHandler("PUT", Constants.UPDATE_BOOK, new UpdateBook());

        httpServer.start();

    }

}
