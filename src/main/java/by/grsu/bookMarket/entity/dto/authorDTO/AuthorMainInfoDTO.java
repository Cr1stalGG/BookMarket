package by.grsu.bookMarket.entity.dto.authorDTO;

import by.grsu.bookMarket.entity.dto.bookDTO.BookMainInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorMainInfoDTO {
    private String name;
    private String description;
    private List<BookMainInfoDTO> books;
}
