package com.example.library.author;

import com.example.library.author.dto.AuthorRequestDto;
import com.example.library.author.dto.AuthorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponseDto> createAuthor(@RequestBody AuthorRequestDto requestDto) {
        AuthorResponseDto authorResponseDto = authorService.crateAuthor(requestDto.getName(), requestDto.getAge());
        return new ResponseEntity<>(authorResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> findAllAuthors() {
        List<AuthorResponseDto> allAuthors = authorService.findAllAuthors();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> findAuthorById(@PathVariable Long id) {
        AuthorResponseDto authorById = authorService.findAuthorById(id);
        return new ResponseEntity<>(authorById, HttpStatus.OK);

    }




}
