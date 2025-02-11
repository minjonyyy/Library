package com.example.library.book;


import com.example.library.BookAuthor;
import com.example.library.author.Author;
import com.example.library.author.AuthorRepository;
import com.example.library.book.dto.BookResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public Book createBook(String title, List<Long> authorIds) {
        Book book = new Book(title);

        for(Long authorId : authorIds) {
            Author author = authorRepository.findByIdOrElseThrow(authorId);

            book.addAuthor(author);
        }

        return bookRepository.save(book);
    }

    public List<BookResponseDto> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookResponseDto::new)
                .collect(Collectors.toList());
    }

//    public BookResponseDto findBookById(Long id) {
//        Book findBook = bookRepository.findByIdOrElseThrow(id);
//        return new BookResponseDto(findBook.getId(), findBook.getTitle(), findBook.getAuthor());
//    }

//    public void deleteBookById(Long id) {
//        Book findBook = bookRepository.findByIdOrElseThrow(id);
//        bookRepository.delete(findBook);
//    }
}
