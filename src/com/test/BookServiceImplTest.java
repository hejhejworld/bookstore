package com.test;

import com.entity.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

public class BookServiceImplTest {
    
    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        System.out.println(bookService.addBook(new Book(null, 1000, 2000, "色", "贾曼", null, 30.0)));
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookService.deleteBookById(19));
    }

    @Test
    public void updateBook() {
        System.out.println(bookService.updateBook(new Book(6, 1000, 2000, "色", "贾曼", null, 30.0)));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(1));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}