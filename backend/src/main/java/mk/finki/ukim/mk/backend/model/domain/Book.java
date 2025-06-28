package mk.finki.ukim.mk.backend.model.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int year;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    public Book(String title, int year, String genre, Author author) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.author = author;
    }
}
