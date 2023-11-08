package com.ECommerceWeb.website.service;

import com.ECommerceWeb.website.Entity.Entity;
import com.ECommerceWeb.website.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void save(Entity b){
        bookRepository.save(b);
    }
    public List<Entity> getAllBooks(){
        return bookRepository.findAll();
    }
    public Entity getBookById(int id){
        return bookRepository.findById(id).get();
    }

    public void deletById(int id){
        bookRepository.deleteById(id);
    }

}
