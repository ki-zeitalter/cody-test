package de.bridgingit.assistantdemo.controller;

import de.bridgingit.assistantdemo.model.Book;
import de.bridgingit.assistantdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class BookController {
    private final BookRepository bookRepository;


    public BookController(@Autowired BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    /**
     * Get all books from the database.
     * @return a list of all books
     */
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();

    }
}
