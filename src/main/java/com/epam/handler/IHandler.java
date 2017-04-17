package com.epam.handler;

import com.epam.actions.Request;
import com.epam.actions.Response;

import java.io.IOException;

/**
 * Created by Katerina_Karpenia on 4/17/2017.
 */
public interface IHandler {

    public void handle(Request request, Response response) throws IOException;

}
