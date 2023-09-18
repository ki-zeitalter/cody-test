package de.bridgingit.assistantdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssistantDemoApplication {

    /**
     * The main method that launches the Spring Boot application.
     *
     * @param args command line arguments passed to the application
     *             The SpringApplication.run() method launches the application,
     *             using AssistantDemoApplication.class to initialize the application context.
     *             The args parameter contains any command line arguments passed to the app.
     */
    public static void main(String[] args) {
        SpringApplication.run(AssistantDemoApplication.class, args);
    }


}
