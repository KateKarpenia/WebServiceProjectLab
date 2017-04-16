package com.epam.actions;

import com.epam.entity.Book;
import com.epam.utils.Constants;

import java.io.*;
import java.util.*;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class Response {

    private Request request;
    private OutputStream outputStream;
    private String uri;
    private int code;
    private String result;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(Request request) {
        this.request = request;
    }


    public void writeResponse() throws IOException {
        result = Constants.SUCCESSFUL_RESPONSE + Constants.WELCOME;
        outputStream.write(result.getBytes());
        outputStream.flush();

    }

    public void writeErrorResponse() throws IOException {
        String errorMessage = Constants.ERROR_RESPONSE + Constants.ERROR;
        outputStream.write(errorMessage.getBytes());
        outputStream.flush();
    }

    public void writeResponseLibrary(List<Book> books) throws IOException {
        result = Constants.SUCCESSFUL_RESPONSE + books;
        outputStream.write(result.getBytes());
        outputStream.flush();
    }

    public void writeResponseBook(Book book) throws IOException {
        result = Constants.SUCCESSFUL_RESPONSE + book;
        outputStream.write(result.getBytes());
        outputStream.flush();
    }


    private String getHeader(int code) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("HTTP/1.1 " + code + " " + getAnswer(code) + "\n");
        buffer.append("Date: " + new Date().toString() + "\n");
        buffer.append("Accept-Ranges: none\n");
        buffer.append("\n");
        System.out.println("getHeader " + buffer.toString());
        return buffer.toString();
    }

    private String getAnswer(int code) {
        switch (code) {
            case 200:
                return "OK";
            case 404:
                return "Not Found";
            default:
                return "Internal Server Error";
        }
    }







}
