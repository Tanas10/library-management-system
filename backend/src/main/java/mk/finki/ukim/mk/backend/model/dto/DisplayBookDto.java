package mk.finki.ukim.mk.backend.model.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import mk.finki.ukim.mk.backend.model.domain.Author;
import mk.finki.ukim.mk.backend.model.domain.Book;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayBookDto(
        Long id,

        String title,
         int year,
        String genre,
        DisplayAuthorDto author) {

    public static DisplayBookDto from(Book book) {
        return new DisplayBookDto(
                book.getId(),
                book.getTitle(),
                book.getYear(),
                book.getGenre(),
                DisplayAuthorDto.fromAuthor(book.getAuthor())
        );
    }
    public static List<DisplayBookDto> from(List<Book> books) {
        return books.stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }
}
