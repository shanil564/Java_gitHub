package com.example.springBootMiniProject.service.implentaion;

import com.example.springBootMiniProject.Repository.BookBorrowRepository;
import com.example.springBootMiniProject.Repository.BookRepository;
import com.example.springBootMiniProject.dto.BookDto;
import com.example.springBootMiniProject.entity.Book;
import com.example.springBootMiniProject.mapper.BookMapper;
import com.example.springBootMiniProject.service.implementation.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @Mock
    private BookMapper bookMapper;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testAddBook() {
        BookDto bookDto = new BookDto();
        bookDto.setBookName("Test Book");
        bookDto.setAuther("Test Author");
        Book book = new Book();
        book.setId(1L);
        book.setBookName("Test Book");
        book.setAuther("Test Author");
        Mockito.when(bookMapper.toEntity(bookDto)).thenReturn(book);
        Mockito.when(bookMapper.toDto(book)).thenReturn(bookDto);
        Mockito.when(bookRepository.save(book)).thenReturn(book);
        BookDto resultBookDto = bookService.addBook(bookDto);
        Mockito.verify(bookMapper).toEntity(bookDto);
        Mockito.verify(bookRepository).save(book);
        Assertions.assertNotNull(resultBookDto);
        Assertions.assertEquals(book.getBookName(), resultBookDto.getBookName());
        Assertions.assertEquals(book.getAuther(), resultBookDto.getAuther());
    }
    @Test
    public void testGetBookById() {
        BookDto bookDto = new BookDto();
        bookDto.setId(1L);
        bookDto.setBookName("Test Book");
        bookDto.setAuther("Test Author");
        Book book = new Book();
        book.setId(1L);
        book.setBookName("Test Book");
        book.setAuther("Test Author");
        Mockito.when(bookMapper.toDto(book)).thenReturn(bookDto);
        Mockito.when(bookRepository.getById(bookDto.getId())).thenReturn(book);
        BookDto result=bookService.getBookById(bookDto.getId());
        Assertions.assertNotNull(result);

    }
    @Test
    public void testDeleteBook(){

    }

}

