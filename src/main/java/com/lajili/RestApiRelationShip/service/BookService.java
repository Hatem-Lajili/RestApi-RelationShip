package com.lajili.RestApiRelationShip.service;

import com.lajili.RestApiRelationShip.dto.requestDto.BookRequestDto;
import com.lajili.RestApiRelationShip.dto.responseDto.BookResponseDto;
import com.lajili.RestApiRelationShip.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    BookResponseDto getBookById(Long bookId);

    Book getBook(Long bookId);

    List<BookResponseDto> getBooks();

    BookResponseDto addBook(BookRequestDto bookRequestDto);

    BookResponseDto addAuthorToBook(Long bookId, Long authorId);

    BookResponseDto addCategoryToBook(Long bookId, Long categoryId);

    BookResponseDto editBook(Long bookId, BookRequestDto bookRequestDto);

    BookResponseDto deleteBook(Long bookId);

    BookResponseDto deleteAuthorFromBook(Long bookId, Long authorId);

    BookResponseDto removeCategoryFromBook(Long bookId, Long categoryId);
}
