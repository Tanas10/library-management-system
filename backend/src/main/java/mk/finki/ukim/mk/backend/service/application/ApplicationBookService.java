package mk.finki.ukim.mk.backend.service.application;

import mk.finki.ukim.mk.backend.model.domain.Book;
import mk.finki.ukim.mk.backend.model.dto.CreateBookDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayBookDto;

import java.util.List;

public interface ApplicationBookService {
    List<DisplayBookDto> findAll();
    DisplayBookDto findById(Long id);
    DisplayBookDto save(CreateBookDto book);
    void delete(Long id);
}
