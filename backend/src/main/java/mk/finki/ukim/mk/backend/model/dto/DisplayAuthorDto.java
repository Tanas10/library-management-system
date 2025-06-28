package mk.finki.ukim.mk.backend.model.dto;

import mk.finki.ukim.mk.backend.model.domain.Author;
import mk.finki.ukim.mk.backend.model.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAuthorDto(
        Long id,
        String name,
        String country) {

    public static DisplayAuthorDto fromAuthor(Author author) {

        return new DisplayAuthorDto(author.getId(), author.getName(), author.getCountry());
    }
    public static List<DisplayAuthorDto> fromAuthor(List<Author> author) {
        return author.stream().map(DisplayAuthorDto::fromAuthor).collect(Collectors.toList());
    }
}
