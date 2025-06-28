package mk.finki.ukim.mk.backend.web.controllers;

import mk.finki.ukim.mk.backend.model.domain.BorrowRecord;
import mk.finki.ukim.mk.backend.model.dto.CreateBorrowRecordDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayBorrowRecordDto;
import mk.finki.ukim.mk.backend.service.application.ApplicationBorrowRecordService;
import mk.finki.ukim.mk.backend.service.domain.BorrowRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow-records")
@CrossOrigin(origins = "*")
public class BorrowRecordController {
    private final ApplicationBorrowRecordService service;

    public BorrowRecordController(ApplicationBorrowRecordService service) {
        this.service = service;
    }

    @GetMapping
    public List<DisplayBorrowRecordDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DisplayBorrowRecordDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DisplayBorrowRecordDto create(@RequestBody CreateBorrowRecordDto record) {
        return service.save(record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
