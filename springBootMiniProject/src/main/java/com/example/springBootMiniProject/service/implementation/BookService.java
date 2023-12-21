package com.example.springBootMiniProject.service.implementation;
import com.example.springBootMiniProject.Constants;
import com.example.springBootMiniProject.Repository.BookBorrowRepository;
import com.example.springBootMiniProject.Repository.BookRepository;
import com.example.springBootMiniProject.dto.BookDto;
import com.example.springBootMiniProject.entity.BookBorrow;
import com.example.springBootMiniProject.exception.BookNotFoundException;
import com.example.springBootMiniProject.exception.InvalidUserException;
import com.example.springBootMiniProject.mapper.BookBorrowMapper;
import com.example.springBootMiniProject.entity.Book;
import com.example.springBootMiniProject.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class BookService implements com.example.springBootMiniProject.service.BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookBorrowRepository bookBorrowRepository;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookBorrowMapper bookBorrowMapper;
    public BookDto addBook(BookDto bookDto){
        Book bookEntity=bookMapper.toEntity(bookDto);
        Book book=bookRepository.save(bookEntity);
        return bookMapper.toDto(book);
    }
    public BookDto getBookById(Long id){
        try{
            Book book= bookRepository.getById(id);
            return bookMapper.toDto(book);
        }catch (EntityNotFoundException e){
            throw new BookNotFoundException(Constants.BOOK_NOT_FOUND_EXCEPTION_MSG);
        }
    }
    public BookDto updateBook(BookDto bookDto){
        Optional<Book> bookEntity=bookRepository.findById(bookDto.getId());
        if (bookEntity.isPresent()){
            if (bookDto.getBookName()!=null){
                bookEntity.get().setBookName(bookDto.getBookName());
            }if (bookDto.getAuther()!=null){
                bookEntity.get().setAuther(bookDto.getAuther());
            }
            bookEntity.get().setIsAvailable(bookDto.getIsAvailable());
            Book book=bookRepository.save(bookEntity.get());
            return bookMapper.toDto(book);
        }else {
            throw new BookNotFoundException(Constants.MSG_NOT_EXISTS);
        }
    }
    public void deleteBook(Long id){
        try {
            bookRepository.deleteById(id);
        }catch (Exception e){
            throw new BookNotFoundException(Constants.MSG_NOT_EXISTS);
        }
    }
    public void bookBorrow(BookBorrow bookBorrow){
        Optional<Book> book=bookRepository.findById(bookBorrow.getBook().getId());
        System.out.printf(String.valueOf(book));
        if (book.get().getIsAvailable()==true){
            bookBorrowRepository.save(bookBorrow);
            book.get().setIsAvailable(false);
            bookRepository.save(book.get());
        }else {
            throw new BookNotFoundException(Constants.BOOK_NOT_FOUND_EXCEPTION_MSG);
        }
    }
    public void returnBook(BookBorrow bookBorrow){
        Optional<Book> book=bookRepository.findById(bookBorrow.getBook().getId());
        List<BookBorrow> bookBorrowList = bookBorrowRepository.findByBookId(bookBorrow.getBook().getId());
        if (book.get().getIsAvailable()==false){
            if (bookBorrowList.get(Constants.ZERO).getBorrowDate().isBefore(bookBorrow.getReturnDate())){
                BookBorrow bookList=bookBorrowList.get((bookBorrowList.size()-Constants.ONE));
                bookList.setReturnDate(bookBorrow.getReturnDate());
                bookBorrowRepository.save(bookList);
                book.get().setIsAvailable(true);
                bookRepository.save(book.get());
            }else{
                throw new InvalidUserException(Constants.INVALID_DATE_EXCEPTION_MSG);
            }
        }else{
            throw new BookNotFoundException(Constants.BOOK_RETURNED_EXCEPTION_MSG);
        }
    }
    public BookBorrow checkBookAvailable(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        List<BookBorrow> bookBorrowList = bookBorrowRepository.findByBookId(id);
        BookBorrow bookBorrow = bookBorrowList.get((bookBorrowList.size()-Constants.ONE));
        if (bookBorrow.getReturnDate() == null) {
            book.get().setIsAvailable(false);
            bookRepository.save(book.get());
        } else {
            book.get().setIsAvailable(true);
            bookRepository.save(book.get());
        }
        return bookBorrow;
    }
}
