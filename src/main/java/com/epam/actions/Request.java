package com.epam.actions;

import java.io.*;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class Request {

    private InputStream inputStream;
    private String uri;
    private String method;


    public Request(InputStream inputStream)  {
        this.inputStream = inputStream;

    }

    public void parse() {
        // Read a set of characters from the socket
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = inputStream.read(buffer);
        }
        catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j=0; j<i; j++) {
            request.append((char) buffer[j]);
        }
        System.out.print("Request parse \r\n" + request.toString());

        uri = parseUri(request.toString());
        System.out.println("parse URI" + " " + uri);

        method = request.substring(0, 5);
        System.out.println("parse Method " + method);

    }

    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1)
                return requestString.substring(index1 + 1, index2);
        }
        return null;
    }

    public String getUri() {
        return uri;
    }

    public String getMethod() {
        return method;
    }


}
