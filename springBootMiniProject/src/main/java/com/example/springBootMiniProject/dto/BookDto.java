package com.example.springBootMiniProject.dto;
public class BookDto {
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
