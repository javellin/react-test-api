package com.yrocha.bookshelfbackend.business;

import com.yrocha.bookshelfbackend.entity.Publisher;
import com.yrocha.bookshelfbackend.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class PublisherBO {

    @Autowired
    private PublisherRepository publisherRepository;

    public Object findAll(Integer page, Integer size, String name) {
        Pageable pageable = PageRequest.of(page, size);

        if (Objects.nonNull(name) && !name.equals("")) {
            return publisherRepository.findByNameStartingWithIgnoreCase(name, pageable);
        }

        return publisherRepository.findAll(pageable);
    }

    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Object findById(Long id) {
        return publisherRepository.findById(id);
    }

    public void delete(Long id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);
        publisher.ifPresent(p -> publisherRepository.delete(p));
    }
}
