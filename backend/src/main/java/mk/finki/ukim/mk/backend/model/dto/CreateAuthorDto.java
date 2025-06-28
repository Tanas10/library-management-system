package mk.finki.ukim.mk.backend.model.dto;

import mk.finki.ukim.mk.backend.model.domain.Author;

public record CreateAuthorDto(
        String name,
        String country) {

    public Author toAuthor() {
        return new Author(name,country);
    }
}
