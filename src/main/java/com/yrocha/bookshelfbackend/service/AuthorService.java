package com.yrocha.bookshelfbackend.service;

import com.yrocha.bookshelfbackend.business.AuthorBO;
import com.yrocha.bookshelfbackend.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorService {

    @Autowired
    private AuthorBO authorBO;

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam(required = false, name = "name") String name) {
        return authorBO.findAll(page, size, name);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Object findById(@PathVariable("id") Long id) {
        return authorBO.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Author save(@RequestBody Author author) {
        return authorBO.save(author);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        authorBO.delete(id);
    }
}
