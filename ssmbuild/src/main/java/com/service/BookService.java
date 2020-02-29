package com.service;

import com.pojo.Books;

import java.util.List;

//业务层接口
public interface BookService {

    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBook(int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询全部书籍
    List<Books> queryAllBook();

    //根据名字查询
    Books queryBookByName(String queryBookName);
}
