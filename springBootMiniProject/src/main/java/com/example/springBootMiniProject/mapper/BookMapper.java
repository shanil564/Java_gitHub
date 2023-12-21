package com.example.springBootMiniProject.mapper;
import com.example.springBootMiniProject.dto.BookDto;
import com.example.springBootMiniProject.entity.Book;
import org.mapstruct.Mapper;
@Mapper
public interface BookMapper {
    BookDto toDto(Book book);
    Book toEntity(BookDto bookDto);

}
