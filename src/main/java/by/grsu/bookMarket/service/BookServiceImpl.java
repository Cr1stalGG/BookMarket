package by.grsu.bookMarket.service;

import by.grsu.bookMarket.entity.dto.bookDTO.BookMainInfoDTO;
import by.grsu.bookMarket.entity.dto.convertor.BookDTOConvertor;
import by.grsu.bookMarket.repository.BookRepository;
import by.grsu.bookMarket.service.api.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookDTOConvertor bookDTOConvertor;

    @Override
    public BookMainInfoDTO findByName(String name) {
        return bookDTOConvertor.convertEntityToDTO(bookRepository.findBookByName(name));
    }

    @Override
    public List<BookMainInfoDTO> find(String query) {
        return bookRepository.findBookByNameLike(query).stream().map(bookDTOConvertor :: convertEntityToDTO).toList();
    }
}
