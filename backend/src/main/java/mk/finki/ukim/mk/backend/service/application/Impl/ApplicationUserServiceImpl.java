package mk.finki.ukim.mk.backend.service.application.Impl;

import mk.finki.ukim.mk.backend.model.dto.CreateUserDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayUserDto;
import mk.finki.ukim.mk.backend.service.application.ApplicationUserService;
import mk.finki.ukim.mk.backend.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {
    public final UserService userService;

    public ApplicationUserServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<DisplayUserDto> findAll() {
        return DisplayUserDto.fromUser(userService.findAll());
    }

    @Override
    public DisplayUserDto findById(Long id) {
        return DisplayUserDto.fromUser(userService.findById(id));
    }

    @Override
    public DisplayUserDto save(CreateUserDto user) {
        return DisplayUserDto.fromUser(user.toUser());
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }
}
