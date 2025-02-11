package com.example.library.author;

import com.example.library.author.dto.AuthorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorResponseDto crateAuthor(String name, Integer age) {
        Author author = new Author(name, age);

        Author savedAuthor = authorRepository.save(author);

        return new AuthorResponseDto(savedAuthor.getId(), savedAuthor.getName(), savedAuthor.getAge());
    }

    public List<AuthorResponseDto> findAllAuthors() {
        return authorRepository.findAll().stream().map(AuthorResponseDto::listOfDto).toList();
    }

    public AuthorResponseDto findAuthorById(Long id) {

        Author findAuthor = authorRepository.findByIdOrElseThrow(id);
        return new AuthorResponseDto(findAuthor.getId(), findAuthor.getName(), findAuthor.getAge());
    }


}
