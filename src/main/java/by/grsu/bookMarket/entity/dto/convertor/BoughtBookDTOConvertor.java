package by.grsu.bookMarket.entity.dto.convertor;

import by.grsu.bookMarket.entity.BoughtBook;
import by.grsu.bookMarket.entity.dto.bookDTO.BoughtBookMainInfoDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BoughtBookDTOConvertor {
    public BoughtBookMainInfoDTO convertEntityToDTO(BoughtBook boughtBook){
        return BoughtBookMainInfoDTO.builder()
                .name(boughtBook.getName())
                .description(boughtBook.getDescription())
                .author(AuthorDTOConvertor.convertEntityToDTO(boughtBook.getAuthor()))
                .date(boughtBook.getDate())
                .build();
    }
}
