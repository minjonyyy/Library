package com.example.library.book.dto;

import com.example.library.book.Book;
import lombok.Getter;

@Getter
public class BookResponseDto {

    private Long id;
    private String title;
    private String author;


    public BookResponseDto(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;

    }

    public static BookResponseDto bookListDto(Book book) {
        return new BookResponseDto(book.getId(), book.getTitle(), book.getAuthor());
    }
}
