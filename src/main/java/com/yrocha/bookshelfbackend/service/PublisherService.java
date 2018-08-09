package com.yrocha.bookshelfbackend.service;

import com.yrocha.bookshelfbackend.business.PublisherBO;
import com.yrocha.bookshelfbackend.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publishers")
public class PublisherService {

    @Autowired
    private PublisherBO publisherBO;

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam(required = false, name = "name") String name) {
        return publisherBO.findAll(page, size, name);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Object findById(@PathVariable("id") Long id) {
        return publisherBO.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Publisher save(@RequestBody Publisher publisher) {
        return publisherBO.save(publisher);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        publisherBO.delete(id);
    }
}
