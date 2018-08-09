package com.yrocha.bookshelfbackend.repository;

import com.yrocha.bookshelfbackend.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, ObjectId>, MongoRepository<Book, ObjectId> {
    List<Book> findByIsFavorite(boolean isFavorite);
}
