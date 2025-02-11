package com.example.library;

import com.example.library.author.Author;
import com.example.library.book.Book;
import jakarta.persistence.*;

@Entity
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
}
