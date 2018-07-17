package com.gmail.sahglie.spring5webapp.repositories;

import com.gmail.sahglie.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
