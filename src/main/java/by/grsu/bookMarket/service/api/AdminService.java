package by.grsu.bookMarket.service.api;

import by.grsu.bookMarket.entity.dto.authorDTO.AuthorCreationDTO;
import by.grsu.bookMarket.entity.dto.bookDTO.BookCreationDTO;

public interface AdminService {
    void addAuthor(AuthorCreationDTO authorDTO);
    void deleteAuthor(String name);
    void addBook(BookCreationDTO bookDTO);
    void deleteBook(String name);
}
