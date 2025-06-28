package mk.finki.ukim.mk.backend.service.application.Impl;


import mk.finki.ukim.mk.backend.model.domain.Book;
import mk.finki.ukim.mk.backend.model.dto.CreateAuthorDto;
import mk.finki.ukim.mk.backend.model.dto.CreateBookDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayBookDto;
import mk.finki.ukim.mk.backend.service.application.ApplicationBookService;
import mk.finki.ukim.mk.backend.service.domain.AuthorService;
import mk.finki.ukim.mk.backend.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationBookServiceImpl implements ApplicationBookService {

    private final BookService bookService;
    private final AuthorService authorService;

    public ApplicationBookServiceImpl(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return DisplayBookDto.from(bookService.findAll());
    }

    @Override
    public DisplayBookDto findById(Long id) {
        return DisplayBookDto.from(bookService.findById(id));
    }

    @Override
    public DisplayBookDto save(CreateBookDto book) {
        return DisplayBookDto.from(bookService.save(book.toBook(authorService.findById(book.authorId()))));
    }

    @Override
    public void delete(Long id) {
        bookService.delete(id);
    }
}
