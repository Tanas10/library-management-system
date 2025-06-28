package mk.finki.ukim.mk.backend.web.controllers;

import mk.finki.ukim.mk.backend.model.domain.Author;
import mk.finki.ukim.mk.backend.model.dto.CreateAuthorDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayAuthorDto;
import mk.finki.ukim.mk.backend.service.application.ApplicationAuthorService;
import mk.finki.ukim.mk.backend.service.domain.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin(origins = "*")
public class AuthorController {
    private final ApplicationAuthorService service;

    public AuthorController(ApplicationAuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<DisplayAuthorDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DisplayAuthorDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DisplayAuthorDto create(@RequestBody CreateAuthorDto author) {
        return service.save(author);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
