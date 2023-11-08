package com.ECommerceWeb.website.service;

import com.ECommerceWeb.website.Entity.Entity;
import com.ECommerceWeb.website.Entity.MyBookList;
import com.ECommerceWeb.website.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class myBookService {
    @Autowired
    private MyBookRepository myBookRepository;
    public void savaMybooks(MyBookList book){
        myBookRepository.save(book);
    }
    public List<MyBookList> getListOfBooks(){
        return myBookRepository.findAll();
    }
    public void deleteById(int id){
        myBookRepository.deleteById(id);
    }
}
