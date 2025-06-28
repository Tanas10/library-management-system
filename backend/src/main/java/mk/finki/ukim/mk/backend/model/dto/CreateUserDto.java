package mk.finki.ukim.mk.backend.model.dto;

import mk.finki.ukim.mk.backend.model.domain.User;

public record CreateUserDto(
         String fullName,
         String email
) {

    public User toUser() {
        return new User(
          fullName,
          email
        );
    }
}
