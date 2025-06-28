package mk.finki.ukim.mk.backend.service.application;

import mk.finki.ukim.mk.backend.model.domain.User;
import mk.finki.ukim.mk.backend.model.dto.CreateUserDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayUserDto;

import java.util.List;

public interface ApplicationUserService {
    List<DisplayUserDto> findAll();
    DisplayUserDto findById(Long id);
    DisplayUserDto save(CreateUserDto user);
    void delete(Long id);

}
