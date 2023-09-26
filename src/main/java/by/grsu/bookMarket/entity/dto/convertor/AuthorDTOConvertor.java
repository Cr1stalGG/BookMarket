package by.grsu.bookMarket.entity.dto.convertor;

import by.grsu.bookMarket.entity.Author;
import by.grsu.bookMarket.entity.dto.authorDTO.AuthorCreationDTO;
import by.grsu.bookMarket.entity.dto.authorDTO.AuthorMainInfoDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthorDTOConvertor {
    public Author convertCreationDTOToEntity(AuthorCreationDTO source){
        return Author.builder()
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }

    public AuthorMainInfoDTO convertEntityToDTO(Author source){
        return AuthorMainInfoDTO.builder()
                .name(source.getName())
                .description(source.getDescription())
                .books(source.getBooks().stream().map(BookDTOConvertor::convertEntityToDTO).toList())
                .build();
    }
}
