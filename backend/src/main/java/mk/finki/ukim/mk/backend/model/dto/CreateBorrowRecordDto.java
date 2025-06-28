package mk.finki.ukim.mk.backend.model.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import mk.finki.ukim.mk.backend.model.domain.Book;
import mk.finki.ukim.mk.backend.model.domain.BorrowRecord;
import mk.finki.ukim.mk.backend.model.domain.User;

import java.time.LocalDate;

public record CreateBorrowRecordDto(
        long bookId,
        long userId,
        LocalDate borrowDate,
        LocalDate returnDate
) {

    public BorrowRecord toBorrowRecord(Book book, User user) {
        return new BorrowRecord(
           book,
           user,
           borrowDate,
                returnDate
        );
    }
}
