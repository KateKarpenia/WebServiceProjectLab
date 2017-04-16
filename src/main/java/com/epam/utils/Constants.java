package com.epam.utils;

/**
 * Created by Kate on 14.04.17.
 */
public class Constants {

    public static final String SUCCESSFUL_RESPONSE = "HTTP/1.1 200 OK\r\n" +
            "Server: Java Server/1.0\r\n" +
            "Content-Type: text/html\r\n" +
            "Connection: close\r\n\r\n";

    public static final String WELCOME = "Welcome to Library Resource";

    public static final String ERROR_RESPONSE = "HTTP/1.1 404 Resource Not Found\r\n" +
            "Server: Java Server/1.0\r\n" +
            "Content-Type: text/html\r\n" +
            "Connection: close \r\n\r\n";

    public static final String ERROR = "Resurce Not Found";

    public static final String GET = "GET";

    public static final String GET_BOOKS = "/books";

    public static final String GET_CURRENT_BOOK1 = "book/1";

    public static final String GET_CURRENT_BOOK2 = "book/2";

    public static final String WELCOME_PAGE = "/";



}
