package mk.finki.ukim.mk.backend.service.domain;

import mk.finki.ukim.mk.backend.model.domain.Author;

import java.util.List;

public interface AuthorService {
     List<Author> findAll();
     Author findById(Long id);
     Author save(Author author);
     void delete(Long id);
}
