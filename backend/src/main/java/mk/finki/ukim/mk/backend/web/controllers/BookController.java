package mk.finki.ukim.mk.backend.web.controllers;

import mk.finki.ukim.mk.backend.model.domain.Book;
import mk.finki.ukim.mk.backend.model.dto.CreateBookDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayBookDto;
import mk.finki.ukim.mk.backend.service.application.ApplicationBookService;
import mk.finki.ukim.mk.backend.service.domain.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {
    private final ApplicationBookService service;

    public BookController(ApplicationBookService service) {
        this.service = service;
    }

    @GetMapping
    public List<DisplayBookDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DisplayBookDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DisplayBookDto create(@RequestBody CreateBookDto book) {
        return service.save(book);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}


