package by.grsu.bookMarket.entity.dto.convertor;

import by.grsu.bookMarket.entity.BoughtBook;
import by.grsu.bookMarket.entity.dto.bookDTO.BoughtBookMainInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoughtBookDTOConvertor {
    private final AuthorDTOConvertor authorDTOConvertor;

    public BoughtBookMainInfoDTO convertEntityToDTO(BoughtBook boughtBook){
        return BoughtBookMainInfoDTO.builder()
                .name(boughtBook.getName())
                .description(boughtBook.getDescription())
                .author(authorDTOConvertor.convertEntityToDTO(boughtBook.getAuthor()))
                .date(boughtBook.getDate())
                .build();
    }
}
