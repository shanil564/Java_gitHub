package com.example.springBootMiniProject.entity;
import com.example.springBootMiniProject.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = Constants.BOOK)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookName;
    private String auther;
    private boolean isAvailable;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuther() {
        return auther;
    }
    public void setAuther(String auther) {
        this.auther = auther;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }
}
