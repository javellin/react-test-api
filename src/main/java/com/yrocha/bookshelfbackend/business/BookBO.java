package com.yrocha.bookshelfbackend.business;

import com.yrocha.bookshelfbackend.entity.Book;
import com.yrocha.bookshelfbackend.repository.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookBO {

    @Autowired
    private BookRepository bookRepository;

    public Object findAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Object findById(ObjectId id) {
        return bookRepository.findById(id);
    }

    public List<Book> findFavorites() {
        return bookRepository.findByIsFavorite(true);
    }
}
