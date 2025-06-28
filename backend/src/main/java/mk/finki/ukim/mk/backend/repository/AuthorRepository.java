package mk.finki.ukim.mk.backend.repository;

import mk.finki.ukim.mk.backend.model.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {}