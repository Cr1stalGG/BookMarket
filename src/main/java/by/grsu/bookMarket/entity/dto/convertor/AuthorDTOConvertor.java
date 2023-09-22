package by.grsu.bookMarket.entity.dto.convertor;

import by.grsu.bookMarket.entity.Author;
import by.grsu.bookMarket.entity.dto.authorDTO.AuthorCreationDTO;
import by.grsu.bookMarket.entity.dto.authorDTO.AuthorMainInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorDTOConvertor {
    public Author convertCreationDTOToEntity(AuthorCreationDTO authorDTO){
        return Author.builder()
                .name(authorDTO.getName())
                .description(authorDTO.getDescription())
                .build();
    }

    public AuthorMainInfoDTO convertEntityToDTO(Author author){
        return AuthorMainInfoDTO.builder()
                .name(author.getName())
                .description(author.getDescription())
                .build();
    }
}
