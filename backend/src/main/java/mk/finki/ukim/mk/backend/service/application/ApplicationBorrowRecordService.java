package mk.finki.ukim.mk.backend.service.application;

import mk.finki.ukim.mk.backend.model.domain.BorrowRecord;
import mk.finki.ukim.mk.backend.model.dto.CreateBorrowRecordDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayBorrowRecordDto;

import java.util.List;

public interface ApplicationBorrowRecordService {
    List<DisplayBorrowRecordDto> findAll();
    DisplayBorrowRecordDto findById(Long id);
    DisplayBorrowRecordDto save(CreateBorrowRecordDto record);
    void delete(Long id);
}
