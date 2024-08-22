package com.book.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "title", "author", "price", "isbn"})
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Double price;
    @JsonProperty("isbn_number")
    private String isbn;
}
