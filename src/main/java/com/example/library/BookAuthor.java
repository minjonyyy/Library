package com.example.library;

import com.example.library.author.Author;
import com.example.library.book.Book;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bookId")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="authorId")
    private Author author;

    public BookAuthor(Book book, Author author) {
        this.book = book;
        this.author = author;
    }

    public BookAuthor() {}
}
