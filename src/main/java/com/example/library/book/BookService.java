package com.example.library.book;


import com.example.library.book.dto.BookResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookResponseDto createBook(String title, String author) {
        Book book = new Book(title, author);
        Book saved = bookRepository.save(book);

        return new BookResponseDto(saved.getId(), saved.getTitle(), saved.getAuthor());
    }

    public List<BookResponseDto> findAllBooks() {
        return bookRepository.findAll().stream().map(BookResponseDto::bookListDto).toList();
    }

    public BookResponseDto findBookById(Long id) {
        Book findBook = bookRepository.findByIdOrElseThrow(id);
        return new BookResponseDto(findBook.getId(), findBook.getTitle(), findBook.getAuthor());
    }

    public void deleteBookById(Long id) {
        Book findBook = bookRepository.findByIdOrElseThrow(id);
        bookRepository.delete(findBook);
    }
}
