package com.gmail.sahglie.spring5webapp.bootstrap;

import com.gmail.sahglie.spring5webapp.model.Author;
import com.gmail.sahglie.spring5webapp.model.Book;
import com.gmail.sahglie.spring5webapp.model.Publisher;
import com.gmail.sahglie.spring5webapp.repositories.AuthorRepository;
import com.gmail.sahglie.spring5webapp.repositories.BookRepository;
import com.gmail.sahglie.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepo;

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private PublisherRepository publisherRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collection", "some address");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepo.save(harper);
        authorRepo.save(eric);
        bookRepo.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "some address");
        Book noEJB = new Book("J2EE Development withouth EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisherRepo.save(worx);
        authorRepo.save(rod);
        bookRepo.save(noEJB);
    }
}
