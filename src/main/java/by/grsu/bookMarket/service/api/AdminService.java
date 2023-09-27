package by.grsu.bookMarket.service.api;

import by.grsu.bookMarket.entity.dto.authorDTO.AuthorCreationDTO;
import by.grsu.bookMarket.entity.dto.bookDTO.BookCreationDTO;

public interface AdminService {
    void addAuthor(AuthorCreationDTO authorDTO);
    void deleteAuthor(long id);
    void addBook(BookCreationDTO bookDTO);
    void deleteBook(long id);
}
