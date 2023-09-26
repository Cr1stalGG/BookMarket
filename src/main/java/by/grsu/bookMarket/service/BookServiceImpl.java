package by.grsu.bookMarket.service;

import by.grsu.bookMarket.entity.dto.bookDTO.BookMainInfoDTO;
import by.grsu.bookMarket.entity.dto.convertor.BookDTOConvertor;
import by.grsu.bookMarket.repository.BookRepository;
import by.grsu.bookMarket.service.api.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookMainInfoDTO findByName(String name) {
        return BookDTOConvertor.convertEntityToDTO(bookRepository.findBookByName(name));
    }

    @Override
    public List<BookMainInfoDTO> find(String name) {
        return bookRepository.findBookByNameLike(name).stream().map(BookDTOConvertor :: convertEntityToDTO).toList();
    }
}
