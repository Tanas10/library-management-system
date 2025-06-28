package mk.finki.ukim.mk.backend.web.controllers;

import mk.finki.ukim.mk.backend.model.dto.CreateUserDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayUserDto;
import mk.finki.ukim.mk.backend.service.application.ApplicationUserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final ApplicationUserService service;

    public UserController(ApplicationUserService service) {
        this.service = service;
    }

    @GetMapping
    public List<DisplayUserDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DisplayUserDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DisplayUserDto create(@RequestBody CreateUserDto user) {
        return service.save(user);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
