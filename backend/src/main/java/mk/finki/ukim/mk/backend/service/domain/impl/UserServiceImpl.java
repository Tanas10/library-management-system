package mk.finki.ukim.mk.backend.service.domain.impl;

import mk.finki.ukim.mk.backend.model.domain.User;
import mk.finki.ukim.mk.backend.repository.UserRepository;
import mk.finki.ukim.mk.backend.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public User save(User user) {
        return repo.save(user);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

