package com.example.library.book;

import com.example.library.book.dto.BookRequestDto;
import com.example.library.book.dto.BookResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto requestDto) {
        Book savedBook = bookService.createBook(requestDto.getTitle(), requestDto.getAuthorIds());

        return new ResponseEntity<>(new BookResponseDto(savedBook), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> findAllBooks() {
        List<BookResponseDto> allBooks = bookService.findAllBooks();
        return new ResponseEntity<>(allBooks,HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<BookResponseDto> findBookById(@PathVariable Long id) {
//        BookResponseDto bookById = bookService.findBookById(id);
//        return new ResponseEntity<>(bookById,HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
//        bookService.deleteBookById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
