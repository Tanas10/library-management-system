package mk.finki.ukim.mk.backend.service.domain;

import mk.finki.ukim.mk.backend.model.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void delete(Long id);

}
