package com.ECommerceWeb.website.controller;

import com.ECommerceWeb.website.Entity.Entity;
import com.ECommerceWeb.website.Entity.MyBookList;
import com.ECommerceWeb.website.service.BookService;
import com.ECommerceWeb.website.service.myBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class bookController {
@Autowired
    private BookService service;
@Autowired
   private myBookService booksService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/Book_Registration")
    public  String bookRegister(){
        return "BookRegistration";
    }
    @GetMapping("/AvailableBooks")
    public ModelAndView getallBooks(){
        List<Entity>list  = service.getAllBooks();
        //		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
        //return m;
        return new ModelAndView("BookList", "myBook", list);
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Entity b){
        service.save(b);
        return "redirect:/AvailableBooks";
    }
    @GetMapping("my_books")
    public  String getMyBooks(Model model){
        List<MyBookList> list= booksService.getListOfBooks(); //take
        model.addAttribute("myBook",list);
        return "myBooks";

    }@RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
   Entity E= service.getBookById(id);
        MyBookList mb= new MyBookList(E.getId(), E.getName(), E.getAuthor(), E.getPrice());
        booksService.savaMybooks(mb);
   return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public  String editBook(@PathVariable("id") int id, Model model){
        Entity b=service.getBookById(id);
        model.addAttribute("myBook", b);
        return "BookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        service.deletById(id);
        return "redirect:/AvailableBooks";
    }
}
