package com.example.newschool.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name="Book")
@Table(name="book")
public class Book {
    @Id
    @SequenceGenerator(
            name="book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    Long id;

    @Column(
            name="book_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    String book_name;

    @Column(
            name="created_at"
    )
    LocalDate created_at;

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_book_fk"
            )
    )
    @JsonBackReference
    private Student student;

    public Book(String book_name, LocalDate created_at) {
        this.book_name = book_name;
        this.created_at = created_at;
    }
}
