package by.grsu.bookMarket.entity.dto.bookDTO;

import by.grsu.bookMarket.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCreationDTO {
    private String name;
    private String description;
    private Author author;
    private int count;
    private double price;
}
