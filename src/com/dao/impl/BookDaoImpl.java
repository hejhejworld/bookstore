package com.dao.impl;

import com.dao.BookDao;
import com.entity.Book;
import com.entity.Page;

import java.util.List;

public class BookDaoImpl extends BasicDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into book(bookname, author, price, sales, stock, img_path) values(?, ?, ?, ?, ?, ?)";
        return this.update(sql, book.getBookname(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImg_path());
    }

    @Override
    public int deleteBookById(Integer bookid) {
        String sql = "delete from book where bookid = ?";
        return this.update(sql, bookid);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update book set bookname = ?, author = ?, price = ?, sales = ?, stock = ?, img_path = ? where bookid = ?";
        return this.update(sql, book.getBookname(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getBookid());
    }

    @Override
    public Book queryBookById(Integer bookid) {
        String sql = "select bookid, bookname, author, price, sales, stock, img_path from book where bookid = ?";
        return this.querySingle(sql, Book.class, bookid);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select bookid, bookname, author, price, sales, stock, img_path from book";
        return this.queryMultiple(sql, Book.class);
    }

    @Override
    public List<Book> queryItems(Integer currentPage) {
        int star = (currentPage - 1) * 4;
        String sql = "select bookid, bookname, author, price, sales, stock, img_path from book limit ?, ?";
        return this.queryMultiple(sql, Book.class, star, Page.PAGE_SIZE);
    }

    @Override
    public int queryPageTotalCount() {
        String sql = "select count(*) from book";
        Number count = (Number) queryScalar(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryItemsByPrice(int min, int max, Integer currentPage) {
        int star = (currentPage -1) * 4;
        String sql = "select * from book where price > ? and price < ? limit ?, ?";
        return queryMultiple(sql,Book.class, min, max, star, Page.PAGE_SIZE);
    }

    @Override
    public int queryPageTatolCountByPrice(int min, int max) {
        String sql = "select count(*) from book where price > ? and price < ?";
        Number count = (Number) queryScalar(sql, min, max);
        return count.intValue();
    }
}
