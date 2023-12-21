package com.example.springBootMiniProject.Repository;

import com.example.springBootMiniProject.entity.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookBorrowRepository extends JpaRepository<BookBorrow,Long> {
    List<BookBorrow> findByBookId(Long bookId);
}
