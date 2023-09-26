package by.grsu.bookMarket.entity.dto.bookDTO;

import by.grsu.bookMarket.entity.dto.authorDTO.AuthorMainInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoughtBookMainInfoDTO {
    private String name;
    private String description;
    private List<AuthorMainInfoDTO> authors;
    private Date date;
}
