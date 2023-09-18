package de.bridgingit.assistantdemo.model;

import de.bridgingit.assistantdemo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Dieser Kontroller liefert alle Autoren. Ein Endpunkt liefert ausserdem alle Bücher eines Autors
 */
@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(@Autowired AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable int id) {
        
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        return authorRepository.findById(id).map(a -> {
            a.setName(author.getName());

            return authorRepository.save(a);
        }).orElseThrow(() -> new AuthorNotFoundException(id));
    }
//    @DeleteMapping("/authors/{id}")
//    public void deleteAuthor(@PathVariable int id) {
//        authorRepository.deleteById(id);
//    }
//    @GetMapping("/authors/{id}/books")
//    public Iterable<Book> getAuthorBooks(@PathVariable int id) {
//        return authorRepository.findById(id).map(a -> a.getBooks()).orElseThrow(() -> new AuthorNotFoundException(id));
//    }
}
