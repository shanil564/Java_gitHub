package com.example.springBootMiniProject.dto;
import com.example.springBootMiniProject.entity.ApplicationUser;
import com.example.springBootMiniProject.entity.Book;
import com.example.springBootMiniProject.entity.BookBorrow;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
public class BookBorrowDto {
    private Long id;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private ApplicationUser applicationUser;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }
    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
