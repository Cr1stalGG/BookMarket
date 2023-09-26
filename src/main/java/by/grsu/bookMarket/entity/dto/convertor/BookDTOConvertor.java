package by.grsu.bookMarket.entity.dto.convertor;

import by.grsu.bookMarket.entity.Book;
import by.grsu.bookMarket.entity.BoughtBook;
import by.grsu.bookMarket.entity.dto.bookDTO.BookCreationDTO;
import by.grsu.bookMarket.entity.dto.bookDTO.BookMainInfoDTO;
import lombok.experimental.UtilityClass;

import java.sql.Date;
import java.time.LocalDate;


@UtilityClass
public class BookDTOConvertor {
    public Book convertCreationDTOToEntity(BookCreationDTO source){
        return Book.builder()
                .name(source.getName())
                .description(source.getDescription())
                .authors(source.getAuthors())
                .price(source.getPrice())
                .build();
    }

    public BookMainInfoDTO convertEntityToDTO(Book source){
        return BookMainInfoDTO.builder()
                .name(source.getName())
                .description(source.getDescription())
                .authors(source.getAuthors().stream().map(AuthorDTOConvertor::convertEntityToDTO).toList())
                .price(source.getPrice())
                .build();
    }

    public BoughtBook convertBookToBoughtBook(Book source){
        return BoughtBook.builder()
                .name(source.getName())
                .description(source.getDescription())
                .authors(source.getAuthors())
                .date(Date.valueOf(LocalDate.now()))
                .build();
    }
}
