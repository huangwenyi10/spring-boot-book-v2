package com.example.demo.properties;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Ay
 * @create 2019/08/31
 **/
public class BookProperties {

    @Value("${com.ay.book.name}")
    private String bookName;
    @Value("${com.ay.book.author}")
    private String author;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
