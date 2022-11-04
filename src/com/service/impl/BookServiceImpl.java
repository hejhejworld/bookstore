package com.service.impl;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.entity.Book;
import com.entity.Page;
import com.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer bookid) {
        return bookDao.deleteBookById(bookid);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer bookid) {
        return bookDao.queryBookById(bookid);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(Integer currentPage) {

        int pageTotalCount = bookDao.queryPageTotalCount();
        int pageTatol = pageTotalCount / Page.PAGE_SIZE;
        if (pageTotalCount % Page.PAGE_SIZE > 0) {
            pageTatol++;
        }
        List<Book> items = bookDao.queryItems(currentPage);

        return new Page<Book>(currentPage, pageTatol, pageTotalCount, items);
    }

    @Override
    public Page<Book> queryBooksByPrice(Integer currentPage, int min, int max) {
        int pageTotalCount = bookDao.queryPageTatolCountByPrice(min, max);
        int pageTatol = pageTotalCount / Page.PAGE_SIZE;
        if (pageTotalCount % Page.PAGE_SIZE > 0) {
            pageTatol++;
        }
        List<Book> items = bookDao.queryItemsByPrice(min, max, currentPage);
        return new Page<Book>(currentPage, pageTatol, pageTotalCount, items);
    }
}
