package mk.finki.ukim.mk.backend.service.domain.impl;

import mk.finki.ukim.mk.backend.model.domain.Book;
import mk.finki.ukim.mk.backend.repository.BookRepository;
import mk.finki.ukim.mk.backend.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepo;

    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Book findById(Long id) {
        return bookRepo.findById(id).orElseThrow();
    }

    public Book save(Book book) {
        return bookRepo.save(book);
    }

    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
}
