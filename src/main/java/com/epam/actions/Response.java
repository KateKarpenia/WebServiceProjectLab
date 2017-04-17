package com.epam.actions;

import com.epam.utils.Constants;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class Response {

    private OutputStream outputStream;
    private String result;
    private String body;
    private String statusCode;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write() throws IOException {
        result = Constants.SUCCESSFUL_RESPONSE + body;
        outputStream.write(result.getBytes());
        outputStream.flush();
    }

    public void writeErrorResponse() throws IOException {
        String errorMessage = Constants.ERROR_RESPONSE + Constants.ERROR;
        outputStream.write(errorMessage.getBytes());
        outputStream.flush();
    }

    public void writeUpdateResponse() throws IOException {
        result = Constants.UPDATED_RESPONSE + body;
        outputStream.write(result.getBytes());
        outputStream.flush();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
