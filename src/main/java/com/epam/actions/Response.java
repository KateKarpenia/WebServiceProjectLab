package com.epam.actions;

import com.epam.utils.Constants;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class Response {

    private OutputStream outputStream;
    private String result;
    private String body;
    private String statusCode;
    private String version;
    private String contentType;
    private String contentLength;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public static void createResponse(Response resp, Request rq) {

        String body = "";
        resp.setVersion(rq.getVersion());
        resp.setContentLength(String.valueOf(body.getBytes().length));
        resp.setBody(body);
        resp.setContentType(rq.getContentType());

        try {
            resp.write();
        } catch (IOException e) {
        }
    }

    public void write() throws IOException {

        Map<String, String> responseMap = new LinkedHashMap<String, String>();

        responseMap.put(version, statusCode);

        responseMap.put(Constants.SERVER, Constants.SERVER_VALUE);

        if (!contentLength.isEmpty()) {
            responseMap.put(Constants.CONTENT_TYPE, contentType + "\r\n");
        }
        if (!contentLength.isEmpty()) {
            responseMap.put(Constants.CONTENT_LENGTH, contentLength + "\r\n");
        }

        responseMap.put(Constants.CONNECTION, Constants.CONNECTION_VALUE);

        if (!body.isEmpty()) {
            responseMap.put(Constants.BODY, body);
        }

        String response = "";


        for (Map.Entry<String, String> pair : responseMap.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (key.equals(Constants.BODY)) {
                response += value;
            } else {
                response += key + value;
            }
        }
        outputStream.write(response.getBytes());
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }



    @Override
    public String toString() {
        return "Response{" +
                "outputStream =" + outputStream +
                ", version='" + version + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", contentType='" + contentType + '\'' +
                ", contentLength='" + contentLength + '\'' +
                ", body='" + body + '\'' +
                '}';
    }


}
