package com.example.springBootMiniProject.service;

import com.example.springBootMiniProject.dto.BookDto;
import com.example.springBootMiniProject.entity.BookBorrow;

public interface BookService {
    BookDto addBook(BookDto bookDto);
    BookDto getBookById(Long id);
    BookDto updateBook(BookDto bookDto);
    void deleteBook(Long id);
    void bookBorrow(BookBorrow bookBorrow);
    BookBorrow checkBookAvailable(Long id);
    void returnBook(BookBorrow bookBorrow);

}
