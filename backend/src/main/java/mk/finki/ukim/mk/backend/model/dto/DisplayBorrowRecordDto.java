package mk.finki.ukim.mk.backend.model.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import mk.finki.ukim.mk.backend.model.domain.Book;
import mk.finki.ukim.mk.backend.model.domain.BorrowRecord;
import mk.finki.ukim.mk.backend.model.domain.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record DisplayBorrowRecordDto(
         Long id,


 DisplayBookDto book,


DisplayUserDto user,

LocalDate borrowDate,
LocalDate returnDate) {

    public static DisplayBorrowRecordDto from(BorrowRecord borrowRecord) {
        return new DisplayBorrowRecordDto(
          borrowRecord.getId(),
          DisplayBookDto.from(borrowRecord.getBook()),
          DisplayUserDto.fromUser(borrowRecord.getUser()),
          borrowRecord.getBorrowDate(),
          borrowRecord.getReturnDate()
        );
    }
    public static List<DisplayBorrowRecordDto> from(List<BorrowRecord> borrowRecords) {
        return borrowRecords.stream().map(DisplayBorrowRecordDto::from).collect(Collectors.toList());
    }
}
