package de.bridgingit.assistantdemo.repository;

import de.bridgingit.assistantdemo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
