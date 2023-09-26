package by.grsu.bookMarket.entity.dto.convertor;

import by.grsu.bookMarket.entity.BoughtBook;
import by.grsu.bookMarket.entity.dto.bookDTO.BoughtBookMainInfoDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BoughtBookDTOConvertor {
    public BoughtBookMainInfoDTO convertEntityToDTO(BoughtBook source){
        return BoughtBookMainInfoDTO.builder()
                .name(source.getName())
                .description(source.getDescription())
                .authors(source.getAuthors().stream().map(AuthorDTOConvertor::convertEntityToDTO).toList())
                .date(source.getDate())
                .build();
    }
}
