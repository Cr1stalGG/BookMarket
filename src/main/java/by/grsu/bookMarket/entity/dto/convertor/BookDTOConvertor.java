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
    public Book convertCreationDTOToEntity(BookCreationDTO bookDTO){
        return Book.builder()
                .name(bookDTO.getName())
                .description(bookDTO.getDescription())
                .author(bookDTO.getAuthor())
                .price(bookDTO.getPrice())
                .build();
    }

    public BookMainInfoDTO convertEntityToDTO(Book book){
        return BookMainInfoDTO.builder()
                .name(book.getName())
                .description(book.getDescription())
                .author(AuthorDTOConvertor.convertEntityToDTO(book.getAuthor()))
                .price(book.getPrice())
                .build();
    }

    public BoughtBook convertBookToBoughtBook(Book book){
        return BoughtBook.builder()
                .name(book.getName())
                .description(book.getDescription())
                .author(book.getAuthor())
                .date(Date.valueOf(LocalDate.now()))
                .build();
    }
}
