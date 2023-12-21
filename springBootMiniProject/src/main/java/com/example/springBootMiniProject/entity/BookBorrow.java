package com.example.springBootMiniProject.entity;
import com.example.springBootMiniProject.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Entity
@Table(name = Constants.BORROW)
public class BookBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Book book;
    @JsonFormat(pattern = Constants.DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    private LocalDate borrowDate;
    @JsonFormat(pattern = Constants.DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    private LocalDate returnDate;
    @ManyToOne
    @JoinColumn(name = Constants.USER_ID)
    @JsonIgnoreProperties({Constants.ROLE,"bookBorrowList"})
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
