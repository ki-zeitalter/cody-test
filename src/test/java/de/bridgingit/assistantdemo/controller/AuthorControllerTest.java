package de.bridgingit.assistantdemo.controller;

import de.bridgingit.assistantdemo.model.Author;
import de.bridgingit.assistantdemo.model.AuthorController;
import de.bridgingit.assistantdemo.repository.AuthorRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AuthorControllerTest {

    @Test
    public void testUpdateAuthor() {

        // Existing author
        Author existingAuthor = new Author();
        existingAuthor.setId(1L);
        existingAuthor.setName("John Doe");

        // Mock repository to return existing author
        AuthorRepository mockRepo = mock(AuthorRepository.class);
        when(mockRepo.findById(1)).thenReturn(Optional.of(existingAuthor));

        // Updated author
        Author updatedAuthor = new Author();
        updatedAuthor.setName("Jane Doe");

        // Controller with mocked repository
        AuthorController controller = new AuthorController(mockRepo);

        // Call method under test
        Author result = controller.updateAuthor(1, updatedAuthor);

        // Assert
        assertEquals("Jane Doe", result.getName());
        verify(mockRepo).findById(1);
        verify(mockRepo).save(existingAuthor);
    }

}
