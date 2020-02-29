package com.service;

import com.dao.BookMapper;
import com.pojo.Books;

import java.util.List;

//业务层实现类
public class BookServiceImpl implements BookService {

    //Service调用dao层：组合dao
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books queryBookByName(String queryBookName) {
        return bookMapper.queryBookByName(queryBookName);
    }
}
