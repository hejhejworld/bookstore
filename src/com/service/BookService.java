package com.service;

import com.entity.Book;
import com.entity.Page;

import java.util.List;

public interface BookService {

    public int addBook(Book book);

    public int deleteBookById(Integer bookid);

    public int updateBook(Book book);

    public Book queryBookById(Integer Bookid);

    public List<Book> queryBooks();

    public Page<Book> page(Integer currentPage);

    public Page<Book> queryBooksByPrice(Integer currentPage, int min, int max);
}
