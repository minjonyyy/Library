package com.example.library.book;

import com.example.library.BookAuthor;
import com.example.library.author.Author;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookAuthor> bookAuthors = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public Book() {

    }

    public void addAuthor(Author author) {
        BookAuthor bookAuthor = new BookAuthor(this, author);
        this.bookAuthors.add(bookAuthor);
    }
}
