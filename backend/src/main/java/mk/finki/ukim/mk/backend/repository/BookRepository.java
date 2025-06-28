package mk.finki.ukim.mk.backend.repository;

import mk.finki.ukim.mk.backend.model.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}