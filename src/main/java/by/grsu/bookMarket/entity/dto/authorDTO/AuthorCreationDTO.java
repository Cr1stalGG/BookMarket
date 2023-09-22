package by.grsu.bookMarket.entity.dto.authorDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorCreationDTO {
    private String name;
    private String description;
}
