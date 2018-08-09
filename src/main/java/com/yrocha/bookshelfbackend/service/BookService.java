package com.yrocha.bookshelfbackend.service;

import com.yrocha.bookshelfbackend.business.BookBO;
import com.yrocha.bookshelfbackend.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookService {

    @Autowired
    private BookBO bookBO;

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return bookBO.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Object findById(@PathVariable("id") String id) {
        return bookBO.findById(new ObjectId(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book save(@RequestBody Book book) {
        return bookBO.save(book);
    }

    @RequestMapping(path = "/favorites", method = RequestMethod.GET)
    public List<Book> findFavorites() {
        return bookBO.findFavorites();
    }
}
