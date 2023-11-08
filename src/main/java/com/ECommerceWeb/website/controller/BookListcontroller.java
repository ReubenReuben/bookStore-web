package com.ECommerceWeb.website.controller;

import com.ECommerceWeb.website.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookListcontroller {
    @Autowired
private MyBookRepository myBookRepository;
    @RequestMapping("/deleteMyList/{id}")
    public String deleteAbook(@PathVariable("id") int id){
        myBookRepository.deleteById(id);
        return "redirect:/my_books";
    }

}
