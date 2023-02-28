package com.example.fullstackbookreviewer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.Objects;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Book {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @NaturalId
    private String isbn;
    private String author;
    private String thumbnailUrl;
    private String description;
    private String bublisher;
    private Long pages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(isbn, book.isbn) &&
                Objects.equals(author, book.author) && Objects.equals(thumbnailUrl, book.thumbnailUrl) &&
                Objects.equals(description, book.description) && Objects.equals(bublisher, book.bublisher) &&
                Objects.equals(pages, book.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn, author, thumbnailUrl, description, bublisher, pages);
    }
}
