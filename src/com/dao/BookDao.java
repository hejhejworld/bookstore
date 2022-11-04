package com.dao;

import com.entity.Book;

import java.util.List;

public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer Bookid);

    public int updateBook(Book book);

    public Book queryBookById(Integer Bookid);

    public List<Book> queryBooks();

    public List<Book> queryItems(Integer currentPage);

    public int queryPageTotalCount();

    public List<Book> queryItemsByPrice(int min, int max, Integer currentPage);

    public int queryPageTatolCountByPrice(int min , int max);
}
