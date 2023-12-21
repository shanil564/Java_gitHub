package com.example.springBootMiniProject.mapper;

import com.example.springBootMiniProject.dto.BookBorrowDto;
import com.example.springBootMiniProject.entity.BookBorrow;
import org.mapstruct.Mapper;

@Mapper
public interface BookBorrowMapper {
    BookBorrow toEntity(BookBorrowDto bookBorrowDto);
    BookBorrowDto toDto(BookBorrow bookBorrow);
}
