package mk.finki.ukim.mk.backend.service.application;

import mk.finki.ukim.mk.backend.model.domain.Author;
import mk.finki.ukim.mk.backend.model.dto.CreateAuthorDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayAuthorDto;

import java.util.List;

public interface ApplicationAuthorService {
     List<DisplayAuthorDto> findAll();
     DisplayAuthorDto findById(Long id);
     DisplayAuthorDto save(CreateAuthorDto author);
     void delete(Long id);
}
