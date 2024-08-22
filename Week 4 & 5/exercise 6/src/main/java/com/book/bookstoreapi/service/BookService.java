package com.book.bookstoreapi.service;

import com.book.bookstoreapi.model.Book;
import com.book.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private static BookRepository bookRepository;

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public static List<Book> getBooksByFilter(String title, String author) {
        if (title != null && author != null) {
            return bookRepository.findByTitleAndAuthor(title, author);
        } else if (title != null) {
            return bookRepository.findByTitle(title);
        } else if (author != null) {
            return bookRepository.findByAuthor(author);
        } else {
            return bookRepository.findAll();
        }
    }
}
