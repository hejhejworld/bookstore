package com.test;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.entity.Book;
import org.junit.Test;

import java.util.List;

public class BookDaoImplTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        System.out.println(bookDao.addBook(new Book(null, 1000, 2000, "色", "贾曼", null, 30.0)));
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDao.deleteBookById(18));
    }

    @Test
    public void updateBook() {
        System.out.println(bookDao.updateBook(new Book(9, 1000, 2000, "色", "贾曼", null, 30.0)));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(1));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}