package com.example.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 描述：自定义属性
 * @author Ay
 * @create 2019/08/31
 **/
@Component
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
