package com.controller;

import com.pojo.Books;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller调业务层service
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;


    @RequestMapping("/allBook")
    public String list(Model model){                             // //查询所有书籍
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list", books);
        return "allBook";
    }

    @RequestMapping("/toAddBook")                                   //跳转到增加书籍页面
    public String toAddPaper(){
        return "addBook";
    }

    @RequestMapping("/addBook")                                    //增加书籍
    public String addBook(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(Model model, int id){             ////跳转到修改书籍页面
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book", books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")                                 //修改书籍
    public String updateBook(Books books, Model model){
        System.out.println(books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook")                                 //删除书籍
    public String deleteBook(int id){
        bookService.deleteBook(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBookByName(String queryBookName, Model model){
        Books books = bookService.queryBookByName(queryBookName);
        System.out.println(books);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        model.addAttribute("list", list);
        return "allBook";
    }
}
