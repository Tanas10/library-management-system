package mk.finki.ukim.mk.backend.service.domain;

import mk.finki.ukim.mk.backend.model.domain.BorrowRecord;

import java.util.List;

public interface BorrowRecordService {
    List<BorrowRecord> findAll();
    BorrowRecord findById(Long id);
    BorrowRecord save(BorrowRecord record);
    void delete(Long id);
}
