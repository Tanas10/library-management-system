package mk.finki.ukim.mk.backend.service.domain.impl;

import mk.finki.ukim.mk.backend.model.domain.Author;
import mk.finki.ukim.mk.backend.repository.AuthorRepository;
import mk.finki.ukim.mk.backend.service.domain.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repo;

    public AuthorServiceImpl(AuthorRepository repo) {
        this.repo = repo;
    }

    public List<Author> findAll() {
        return repo.findAll();
    }

    public Author findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Author save(Author author) {
        return repo.save(author);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
