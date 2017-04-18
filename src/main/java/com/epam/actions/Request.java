package com.epam.actions;

import com.epam.utils.Constants;
import com.epam.utils.HttpMethodUtils;
import com.epam.utils.SplitUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class Request {

    private InputStream inputStream;
    private String uri;
    private String method;
    private String body;

    private String path;
    private String version;
    private int contentLenght = 0;
    private String contentType;

    public Request (BufferedReader bufferedReader) {
        parseRequest(bufferedReader);
    }

    private void parseRequest(BufferedReader bufferedReader) {

        List<String> headerValue = null;
        try {
            headerValue = HttpMethodUtils.getHeaderValue(bufferedReader);
        } catch (IOException e) {
        }


        for (String value : headerValue) {

            if (value.startsWith(Constants.GET)) {

                method = Constants.GET;
                path = SplitUtils.getCertainSplitValueBy(value, Constants.PATH, Constants.SPACE);
                version = SplitUtils.getCertainSplitValueBy(value, Constants.VERSION, Constants.SPACE);
                System.out.println("GET " + method + path + version);

            } else if (value.startsWith(Constants.POST)) {

                method = Constants.POST;
                path = SplitUtils.getCertainSplitValueBy(value, Constants.PATH, Constants.SPACE);
                version = SplitUtils.getCertainSplitValueBy(value, Constants.VERSION, Constants.SPACE);
                System.out.println("POST " + method + path + version);

            }else if (value.startsWith(Constants.DELETE)) {

                method = Constants.DELETE;
                path = SplitUtils.getCertainSplitValueBy(value, Constants.PATH, Constants.SPACE);
                version = SplitUtils.getCertainSplitValueBy(value, Constants.VERSION, Constants.SPACE);
                System.out.println("DELETE " + method + path + version);

            } else if (value.startsWith(Constants.PUT)) {

                method = Constants.PUT;
                path = SplitUtils.getCertainSplitValueBy(value, Constants.PATH, Constants.SPACE);
                version = SplitUtils.getCertainSplitValueBy(value, Constants.VERSION, Constants.SPACE);
                System.out.println("PUT " + method + path + version);

            } else if (value.startsWith(Constants.CONTENT_LENGTH)) {
                contentLenght = Integer.parseInt(SplitUtils.getCertainSplitValueBy(value, Constants.VALUE,
                        Constants.COLON_SPLITTER));
            } else if (value.startsWith(Constants.CONTENT_TYPE)) {

                contentType = SplitUtils.getCertainSplitValueBy(value, Constants.VALUE, Constants.COLON_SPLITTER);
            }

        }

        if (contentLenght > 0) {
            body = headerValue.get(headerValue.size() - 1);
        }

    }

    public int getContentLenght() {
        return contentLenght;
    }

    public void setContentLenght(int contentLenght) {
        this.contentLenght = contentLenght;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public  String validateContentType(String contentType) {
        if (contentType != null) {
            return contentType;
        } else {
            return "application/json";
        }
    }


    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", contentLength=" + contentLenght +
                ", contentType='" + contentType + '\'' +
                ", body='" + body + '\'' +
                '}';
    }




}
