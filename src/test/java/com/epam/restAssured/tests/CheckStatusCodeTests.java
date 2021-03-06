package com.epam.restAssured.tests;

import com.epam.restAssured.ConfigSteps;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Katerina_Karpenia on 4/19/2017.
 */

public class CheckStatusCodeTests extends ConfigSteps {

    @Test
    public void checkStatusCodeGetBooksTest() {
        given().
                when().get("/books").
                then().statusCode(200);
    }

    @Test
    public void checkStatusCodeAddNewBookByUsingTestNGTest() {
        Response addNewBook = given().
                when().post("/book/new").
                thenReturn();
        Assert.assertEquals(addNewBook.getStatusCode(), 201);
    }

//    @Test
//    public void checkStatusCodeGetNotExistingBookTest() {
//        given().
//                when().get("/book/777").
//                then().statusCode(404);
//    }


}
