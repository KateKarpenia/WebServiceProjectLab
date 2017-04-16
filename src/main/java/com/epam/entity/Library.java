package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class Library {

    private static List<Book> books;

    public static List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Martin Fowler", "Patterns of Enterprise Application Architecture", 232));
        books.add(new Book(2, "Joshua Bloch", "Effective Java", 454));
        return books;
    }

    public static Book getCurrentBook(int i) {
        Book currentBook = Library.getBooks().get(i-1);
        return currentBook;
    }

    public static void addBook(Book book) {
        List<Book> allBook = getBooks();
        allBook.add(book);
    }

}
