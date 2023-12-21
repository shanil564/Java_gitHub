package com.example.springBootMiniProject.controller;
import com.example.springBootMiniProject.Constants;
import com.example.springBootMiniProject.dto.BookDto;
import com.example.springBootMiniProject.dto.Response;
import com.example.springBootMiniProject.entity.BookBorrow;
import com.example.springBootMiniProject.exception.BookNotFoundException;
import com.example.springBootMiniProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(Constants.BOOK_PATH)
public class BookController {
    @Autowired
    private BookService bookService;
    @PreAuthorize(Constants.HAS_AUTHORITY_WRITE)
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
        Response response=new Response();
        BookDto book=bookService.addBook(bookDto);
        response.setStatus(true);
        response.setResponse(book);
        return ResponseEntity.ok(response);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_READ)
    @GetMapping(Constants.PATH_VARIABLE_ID)
    public ResponseEntity<?> getBook(@PathVariable Long id) throws BookNotFoundException {
            BookDto bookDto=bookService.getBookById(id);
            Response response=new Response();
            response.setStatus(true);
            response.setResponse(bookDto);
            return ResponseEntity.ok(response);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_UPDATE)
    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody BookDto bookDto){
            BookDto book=bookService.updateBook(bookDto);
            Response response=new Response();
            response.setStatus(true);
            response.setResponse(book);
            response.setMessage(Constants.MSG_UPDATED);
            return ResponseEntity.ok(response);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_DELETE)
    @DeleteMapping(Constants.PATH_VARIABLE_ID)
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
            bookService.deleteBook(id);
            Response response=new Response();
            response.setMessage(Constants.MSG_DELETED);
            response.setStatus(true);
            return ResponseEntity.ok(response);
    }
   @PreAuthorize(Constants.HAS_AUTHORITY_UPDATE)
    @PostMapping(Constants.BORROW_BOOK_PATH)
    public ResponseEntity<?> BookBorrow(@RequestBody BookBorrow bookBorrow){
        bookService.bookBorrow(bookBorrow);
        Response response=new Response();
        response.setStatus(true);
        response.setMessage(Constants.MSG_BORROW);
        return ResponseEntity.ok(response);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_UPDATE)
    @PostMapping(Constants.RETURN_BOOK_PATH)
    public ResponseEntity<?> returnBook(@RequestBody BookBorrow bookBorrow){
        bookService.returnBook(bookBorrow);
        Response response=new Response();
        response.setStatus(true);
        response.setMessage(Constants.MSG_RETURNED);
        return ResponseEntity.ok(response);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_READ)
    @GetMapping(Constants.CHECKBOOK_PATH+Constants.PATH_VARIABLE_ID)
    public ResponseEntity<?> checkBookAvailable(@PathVariable Long id){
        try {
            BookBorrow bookBorrow =bookService.checkBookAvailable(id);
            Response response=new Response();
            response.setStatus(true);
            response.setResponse(bookBorrow);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            throw new BookNotFoundException(Constants.BOOK_NOT_FOUND_EXCEPTION_MSG);
        }
    }
}
