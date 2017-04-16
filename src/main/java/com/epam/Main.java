package com.epam;


import java.io.IOException;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        HttpServer httpServer = new HttpServer(8085);

        httpServer.start();

    }

}
