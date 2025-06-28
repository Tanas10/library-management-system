package mk.finki.ukim.mk.backend.service.application.Impl;

import mk.finki.ukim.mk.backend.model.domain.Author;
import mk.finki.ukim.mk.backend.model.dto.CreateAuthorDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayAuthorDto;
import mk.finki.ukim.mk.backend.service.application.ApplicationAuthorService;
import mk.finki.ukim.mk.backend.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationAuthorServiceImpl implements ApplicationAuthorService {
    private final AuthorService authorService;

    public ApplicationAuthorServiceImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public List<DisplayAuthorDto> findAll() {
        return DisplayAuthorDto.fromAuthor(authorService.findAll());
    }

    @Override
    public DisplayAuthorDto findById(Long id) {
        return DisplayAuthorDto.fromAuthor(authorService.findById(id));
    }

    @Override
    public DisplayAuthorDto save(CreateAuthorDto author) {
        return DisplayAuthorDto.fromAuthor(authorService.save(author.toAuthor()));
    }

    @Override
    public void delete(Long id) {
        authorService.delete(id);
    }
}
