package by.grsu.bookMarket.entity.dto.bookDTO;

import by.grsu.bookMarket.entity.dto.authorDTO.AuthorMainInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookMainInfoDTO {
    private String name;
    private String description;
    private AuthorMainInfoDTO author;
    private int count;
    private double price;
}
