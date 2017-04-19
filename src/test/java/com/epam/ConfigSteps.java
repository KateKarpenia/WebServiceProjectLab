package com.epam;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * Created by Katerina_Karpenia on 4/19/2017.
 */
public class ConfigSteps {

    @BeforeClass
    public static void setup() {

        String port = System.getProperty("server.port");

        if (port == null) {
            RestAssured.port = 8085;
        }
        else {
            RestAssured.port = Integer.valueOf(port);
        }

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;
    }

}
