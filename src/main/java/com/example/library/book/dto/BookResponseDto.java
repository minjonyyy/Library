package com.example.library.book.dto;

import com.example.library.BookAuthor;
import com.example.library.book.Book;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class BookResponseDto {

    private final Long id;
    private final String title;
    private final List<Long> authorIds;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.authorIds = book.getBookAuthors().stream()
                .map(bookAuthor -> bookAuthor.getAuthor().getId())
                .collect(Collectors.toList());
    }


//    public static BookResponseDto bookListDto(Book book) {
//
//        return new BookResponseDto(
//                book.getId(),
//                book.getTitle(),
//                book.getBookAuthors().stream()
//                        .map(bookAuthor -> bookAuthor.getAuthor().getId())
//                        .collect(Collectors.toList())
//        );
//    }

}
