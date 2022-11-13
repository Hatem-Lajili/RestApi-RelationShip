package com.lajili.RestApiRelationShip.service;

import com.lajili.RestApiRelationShip.dto.requestDto.AuthorRequestDto;
import com.lajili.RestApiRelationShip.dto.responseDto.AuthorResponseDto;
import com.lajili.RestApiRelationShip.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    List<AuthorResponseDto> getAuthors();

    AuthorResponseDto getAuthorById(Long authorId);

    Author getAuthor(Long authorId);

    AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);

    AuthorResponseDto addZipcodeToAuthor(Long authorId, Long zipcodeId);

    AuthorResponseDto editAuthor(Long authorId, AuthorRequestDto authorRequestDto);

    AuthorResponseDto deleteAuthor(Long authorId);

    AuthorResponseDto deleteZipcodeFromAuthor(Long authorId);
}
