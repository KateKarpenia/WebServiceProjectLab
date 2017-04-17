package com.epam.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Katerina_Karpenia on 4/11/2017.
 */

@XmlType(name = "Book", propOrder = {"id", "author", "title", "pages" })
@XmlAccessorType(XmlAccessType.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    @XmlElement(required = true, name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(required = true, name = "author")
    @JsonProperty("author")
    private String author;

    @XmlElement(required = true, name = "title")
    @JsonProperty("title")
    private String title;

    @XmlElement(required = true, name = "pages")
    @JsonProperty("pages")
    private int pages;

    public Book(int id, String author, String title, int pages) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (pages != book.pages) return false;
        if (!author.equals(book.author)) return false;
        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + author.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + pages;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book {" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}' + "\r\n";
    }



}
