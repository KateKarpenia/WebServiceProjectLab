package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class Library {

    private static List<Book> books;
    private static Book book;

    public Library() {
        if (books == null) {
            books = new ArrayList<Book>();
            Book first = new Book(1, "Martin Fowler", "Patterns of Enterprise Application Architecture", 232);
            Book second = new Book(2, "Joshua Bloch", "Effective Java", 454);
            books.add(first);
            books.add(second);
        }
    }

    public static List<Book> getBooks() {
        return books;
    }


    public static Book getCurrentBook(int i) {
        new Library();
        Book currentBook = Library.getBooks().get(i-1);
        return currentBook;
    }

    public static void addBook(Book book) {
        books.add(book);
    }


    public static void deleteBook(Book deletedBook){
        new Library();
//        for (Book book : books) {
//            if (book.getId() == deletedBook.getId()) {
//                books.remove(book);
//            }
//        }
        books.remove(deletedBook);
    }

    public static void updateBook(Book book) {
        new Library();
        for (Book booksArray : books) {
            if (booksArray.getId() == book.getId()) {
                booksArray.setAuthor(book.getAuthor());
                booksArray.setTitle(book.getTitle());
                booksArray.setPages(book.getPages());
            }
        }
    }

}
