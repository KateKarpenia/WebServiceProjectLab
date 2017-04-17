package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina_Karpenia on 4/14/2017.
 */
public class Library {

    private static List<Book> books;
    private static Book book;

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
        List<Book> books = Library.getBooks();
        books.add(book);
//        System.out.println("All books " + books);
    }

    public static void deleteBook(Book deletedBook){

        List<Book> books = Library.getBooks();
        for (Book book : books) {
            if (book.getId() == deletedBook.getId()) {
                books.remove(book);
            }
        }

    }

    public static void updateBook(Book book) {

        List<Book> books = Library.getBooks();
        for (Book booksArray : books) {
            if (booksArray.getId() == book.getId()) {
                booksArray.setAuthor(book.getAuthor());
                booksArray.setTitle(book.getTitle());
                booksArray.setPages(book.getPages());
            }
        }
    }

}
