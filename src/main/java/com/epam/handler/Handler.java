package com.epam.handler;

import com.epam.actions.Request;
import com.epam.actions.Response;

import java.io.IOException;

/**
 * Created by Katerina_Karpenia on 4/17/2017.
 */
public class Handler implements IHandler{

    private String method;
    private String uri;
    private IHandler iHandler;

    public Handler() {
    }

    public Handler(String method, String uri, IHandler iHandler) {
        this.method = method;
        this.uri = uri;
        this.iHandler = iHandler;
    }

    public void handle(Request request, Response response) throws IOException {

    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public IHandler getiHandler() {
        System.out.println("getIHandler " + iHandler);
        return iHandler;
    }

    public void setiHandler(IHandler iHandler) {
        this.iHandler = iHandler;
    }
}
