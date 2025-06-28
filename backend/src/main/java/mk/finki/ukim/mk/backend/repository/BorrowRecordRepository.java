package mk.finki.ukim.mk.backend.repository;

import mk.finki.ukim.mk.backend.model.domain.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {}
