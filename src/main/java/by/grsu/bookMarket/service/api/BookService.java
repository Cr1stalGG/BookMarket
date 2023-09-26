package by.grsu.bookMarket.service.api;

import by.grsu.bookMarket.entity.dto.bookDTO.BookMainInfoDTO;

import java.util.List;

public interface BookService {
    BookMainInfoDTO findByName(String name);
    List<BookMainInfoDTO> find(String name);
}
