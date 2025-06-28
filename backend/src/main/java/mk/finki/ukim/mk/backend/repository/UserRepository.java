package mk.finki.ukim.mk.backend.repository;

import mk.finki.ukim.mk.backend.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
