package com.epam.springTemplate;

import com.epam.entity.Book;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Katerina_Karpenia on 5/2/2017.
 */
public class BookCrudOperationsTests {

    @Test
    public void bookGetMethodRetrievingResponseEntity() {

        RestTemplate restTemplate = new RestTemplate();
        String bookResourceUrl = "http://localhost:8085/book/1";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(bookResourceUrl, String.class);

        int statusCode = responseEntity.getStatusCodeValue();

        HttpStatus statusCodeEntity = responseEntity.getStatusCode();
        statusCodeEntity.value();
        statusCodeEntity.getReasonPhrase();
        statusCodeEntity.is1xxInformational();
        statusCodeEntity.is2xxSuccessful();
        statusCodeEntity.is3xxRedirection();
        statusCodeEntity.is4xxClientError();
        statusCodeEntity.is5xxServerError();

        HttpHeaders httpHeaders = responseEntity.getHeaders();
        List<String> headersValue = httpHeaders.get("HEADER_NAME");
        httpHeaders.getContentType();
        httpHeaders.getContentLength();
        httpHeaders.getLocation();

        String responseBody = responseEntity.getBody();
        responseEntity.hasBody();
        System.out.println(statusCode + " " + httpHeaders + " " + responseBody);

        Assert.assertEquals(responseEntity.getStatusCode().value(), 200);

    }

    @Test
    public void bookPostMethodRetrievingReturningPojo() {

        String bookResourceUrl = "http://localhost:8085/book/new";
        RestTemplate restTemplate = new RestTemplate();

        Book bookToCreate = new Book();
        MultiValueMap<String, String> headers = new HttpHeaders();

        HttpEntity<Book> request = new HttpEntity<Book>(bookToCreate, headers);
        Book book = restTemplate.postForObject(bookResourceUrl, request, Book.class);

        Assert.assertEquals(book.toString(), "Book {id=3, author='Herbert Schildt', title='Java 1.1: The Complete Reference', pages=543}\r\n");

    }

    @Test
    public void bookPutMethodTest() {


        String bookResourceUrl = "http://localhost:8085/book/1";
        String updatedPagesQuantity = "555";

        RestTemplate restTemplate = new RestTemplate();
        Book bookToUpdate = new Book();
        MultiValueMap<String, String> headers = new HttpHeaders();
        HttpEntity<Book> request = new HttpEntity<Book>(bookToUpdate, headers);

        ResponseEntity<Book> updatedBook = restTemplate.exchange(bookResourceUrl, HttpMethod.PUT, request, Book.class);

        Assert.assertTrue(updatedBook.getBody().toString().contains(updatedPagesQuantity));

    }

    @Test
    public void bookDeleteMethodTest() {
        String bookResourceUrl = "http://localhost:8085/book/2";
        RestTemplate restTemplate = new RestTemplate();

        Book bookToDelete = new Book();
        MultiValueMap<String, String> headers = new HttpHeaders();
        HttpEntity<Book> request = new HttpEntity<Book>(bookToDelete, headers);

        ResponseEntity<Book> deletedBook = restTemplate.exchange(bookResourceUrl, HttpMethod.DELETE, request, Book.class);

        Assert.assertEquals(deletedBook.getStatusCodeValue(), 200);

    }


}


