package mk.finki.ukim.mk.backend.service.domain;

import mk.finki.ukim.mk.backend.model.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book save(Book book);
    void delete(Long id);
}
