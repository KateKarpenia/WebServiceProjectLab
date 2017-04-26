package com.epam.tests;

import com.epam.ConfigSteps;
import com.epam.entity.Book;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by Katerina_Karpenia on 4/26/2017.
 */
public class BookCrudOperationsTests extends ConfigSteps{

    @Test
    public void addNewBookTest() {

        // create book
        Book newBook = Book.createNewBook();
        given()
                .contentType("application/json")
                .body(newBook)
                .when().post("/book/new").then()
                .statusCode(201);

        // check that book has been added
        given().when().get("/books").then()
                .body(containsString("\"id\":3,\"author\":\"Herbert Schildt\"")).statusCode(200);
    }

    @Test
    public void getCurrentBookTest() {

        // get book
        Response getCurrentBook = given()
                .contentType("application/json")
                .when().get("/book/1").thenReturn();

        Assert.assertEquals(getCurrentBook.getStatusCode(), 200);
    }

    @Test
    public void verifyBookTitleTest() {
        given()
                .when().get("/book/1")
                .then().body(containsString("Fowler")).statusCode(200);
    }

    @Test
    public void updateBookTest() {

        // update book
        Book updatedBook = Book.updateBook();
        given().contentType("application/json").body(updatedBook)
                .when().put("/book/1")
                .then().statusCode(200);

        // check that book has been updated
        given().when().get("/book/1")
                .then().body(containsString("555"));
    }

    @Test
    public void deleteBookTest() {

        // delete book
        Book deletedBook = Book.deleteBook();
        given().contentType("application/json").body(deletedBook)
                .when().delete("book/2")
                .then().statusCode(200);

        // check that book has been deleted
        given().when().get("/books")
                .then().body(not("Bloch")).statusCode(200);
    }


}
