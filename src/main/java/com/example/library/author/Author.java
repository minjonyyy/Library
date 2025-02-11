package com.example.library.author;

import com.example.library.BookAuthor;
import com.example.library.book.Book;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name="author")
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookAuthor> bookAuthors = new ArrayList<>();


    public Author(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Author() {}

    public void addBook(BookAuthor bookAuthor) {
        bookAuthors.add(bookAuthor);
        bookAuthor.setAuthor(this);
    }
}
