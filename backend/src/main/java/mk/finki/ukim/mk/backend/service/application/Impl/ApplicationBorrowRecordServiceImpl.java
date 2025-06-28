package mk.finki.ukim.mk.backend.service.application.Impl;

import mk.finki.ukim.mk.backend.model.dto.CreateBorrowRecordDto;
import mk.finki.ukim.mk.backend.model.dto.DisplayBorrowRecordDto;
import mk.finki.ukim.mk.backend.service.application.ApplicationBorrowRecordService;
import mk.finki.ukim.mk.backend.service.domain.AuthorService;
import mk.finki.ukim.mk.backend.service.domain.BookService;
import mk.finki.ukim.mk.backend.service.domain.BorrowRecordService;
import mk.finki.ukim.mk.backend.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationBorrowRecordServiceImpl implements ApplicationBorrowRecordService {

    private final BorrowRecordService borrowRecordService;
    private final BookService bookService;
    private final UserService userService;

    public ApplicationBorrowRecordServiceImpl(BorrowRecordService borrowRecordService, BookService bookService, UserService userService) {
        this.borrowRecordService = borrowRecordService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @Override
    public List<DisplayBorrowRecordDto> findAll() {
        return DisplayBorrowRecordDto.from(borrowRecordService.findAll());
    }

    @Override
    public DisplayBorrowRecordDto findById(Long id) {
        return DisplayBorrowRecordDto.from(borrowRecordService.findById(id));
    }

    @Override
    public DisplayBorrowRecordDto save(CreateBorrowRecordDto record) {
        return DisplayBorrowRecordDto.from(record.toBorrowRecord(bookService.findById(record.bookId()), userService.findById(record.userId())));
    }

    @Override
    public void delete(Long id) {
        borrowRecordService.delete(id);
    }
}
