package com.yrocha.bookshelfbackend.repository;

import com.yrocha.bookshelfbackend.entity.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long> {
    Page findByNameStartingWithIgnoreCase(String name, Pageable pageable);
}
