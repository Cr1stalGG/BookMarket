package by.grsu.bookMarket.entity.dto.convertor;

import by.grsu.bookMarket.entity.Book;
import by.grsu.bookMarket.entity.dto.bookDTO.BookCreationDTO;
import by.grsu.bookMarket.entity.dto.bookDTO.BookMainInfoDTO;
import by.grsu.bookMarket.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BookDTOConvertor {
    private final AuthorRepository authorRepository;
    private final AuthorDTOConvertor authorDTOConvertor;

    public Book convertCreationDTOToEntity(BookCreationDTO bookDTO){
        return Book.builder()
                .name(bookDTO.getName())
                .description(bookDTO.getDescription())
                .author(authorRepository.findAuthorByName(bookDTO.getAuthorName()))
                .count(bookDTO.getCount())
                .price(bookDTO.getPrice())
                .build();
    }

    public BookMainInfoDTO convertEntityToDTO(Book book){
        return BookMainInfoDTO.builder()
                .name(book.getName())
                .description(book.getDescription())
                .author(authorDTOConvertor.convertEntityToDTO(book.getAuthor()))
                .count(book.getCount())
                .price(book.getCount())
                .build();
    }
}
