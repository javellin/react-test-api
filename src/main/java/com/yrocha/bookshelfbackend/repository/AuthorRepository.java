package com.yrocha.bookshelfbackend.repository;

import com.yrocha.bookshelfbackend.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
    Page findByNameStartingWithIgnoreCase(String name, Pageable pageable);
}
