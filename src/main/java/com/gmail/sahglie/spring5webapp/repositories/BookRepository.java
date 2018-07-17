package com.gmail.sahglie.spring5webapp.repositories;

import com.gmail.sahglie.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {}
