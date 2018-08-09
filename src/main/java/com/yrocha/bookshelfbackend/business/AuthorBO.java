package com.yrocha.bookshelfbackend.business;

import com.yrocha.bookshelfbackend.entity.Author;
import com.yrocha.bookshelfbackend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class AuthorBO {

    @Autowired
    private AuthorRepository authorRepository;

    public Object findAll(Integer page, Integer size, String name) {
        Pageable pageable = PageRequest.of(page, size);

        if (Objects.nonNull(name) && !name.equals("")) {
            return authorRepository.findByNameStartingWithIgnoreCase(name, pageable);
        }

        return authorRepository.findAll(pageable);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Object findById(Long id) {
        return authorRepository.findById(id);
    }

    public void delete(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        author.ifPresent(a -> authorRepository.delete(a));
    }
}
