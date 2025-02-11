package com.example.library.author.dto;

import com.example.library.author.Author;
import lombok.Getter;

@Getter
public class AuthorResponseDto {
    private final Long id;
    private final String name;
    private final Integer age;

    public AuthorResponseDto(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static AuthorResponseDto listOfDto(Author author) {
        return new AuthorResponseDto(author.getId(), author.getName(), author.getAge());
    }
}
