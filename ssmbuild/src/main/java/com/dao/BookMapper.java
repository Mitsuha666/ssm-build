package com.dao;

import com.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBook(@Param("bookId") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookId")int id);

    //查询全部书籍
    List<Books> queryAllBook();

    //根据名字查询
    Books queryBookByName(@Param("queryBookName") String queryBookName);
}
