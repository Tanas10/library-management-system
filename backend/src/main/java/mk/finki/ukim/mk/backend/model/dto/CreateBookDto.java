package mk.finki.ukim.mk.backend.model.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import mk.finki.ukim.mk.backend.model.domain.Author;
import mk.finki.ukim.mk.backend.model.domain.Book;

public record CreateBookDto(

        String title,
        int year,
        String genre,
        long authorId
) {
   public Book toBook(Author author) {
       return new Book(
         title,
         year,
         genre,
         author
       );
   }

}
