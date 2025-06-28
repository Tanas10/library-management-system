package mk.finki.ukim.mk.backend.service.domain.impl;

import mk.finki.ukim.mk.backend.model.domain.BorrowRecord;
import mk.finki.ukim.mk.backend.repository.BorrowRecordRepository;
import mk.finki.ukim.mk.backend.service.domain.BookService;
import mk.finki.ukim.mk.backend.service.domain.BorrowRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {
    private final BorrowRecordRepository repo;

    public BorrowRecordServiceImpl(BorrowRecordRepository repo) {
        this.repo = repo;
    }

    public List<BorrowRecord> findAll() {
        return repo.findAll();
    }

    public BorrowRecord findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public BorrowRecord save(BorrowRecord record) {
        return repo.save(record);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
