package mk.finki.ukim.mk.backend.model.dto;

import mk.finki.ukim.mk.backend.model.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayUserDto(
         Long id,

         String fullName,
         String email
) {

    public static DisplayUserDto fromUser(User user) {

        return new DisplayUserDto(user.getId(), user.getFullName(), user.getEmail());
    }
    public static List<DisplayUserDto> fromUser(List<User> user) {
        return user.stream().map(DisplayUserDto::fromUser).collect(Collectors.toList());
    }
}
