package de.bridgingit.assistantdemo.model;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(int id) {
        super("Author with id " + id + " not found");
    }
}
