package com.epam.tests;

import com.epam.ConfigSteps;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Katerina_Karpenia on 4/20/2017.
 */
public class CheckHeadersTests extends ConfigSteps{

    @Test
    public void checkHeadersTest() {
        Response addNewBook = given().
                header("Accept", "application/json").
                when().get("/books").
                thenReturn();
        Assert.assertEquals(addNewBook.getContentType(), "application/json");
    }



}
