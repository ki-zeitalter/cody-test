package de.bridgingit.assistantdemo.repository;

import de.bridgingit.assistantdemo.model.Author;
import de.bridgingit.assistantdemo.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByAuthor(Author author);
}
