package by.grsu.bookMarket.service;

import by.grsu.bookMarket.entity.dto.authorDTO.AuthorCreationDTO;
import by.grsu.bookMarket.entity.dto.bookDTO.BookCreationDTO;
import by.grsu.bookMarket.entity.dto.convertor.AuthorDTOConvertor;
import by.grsu.bookMarket.entity.dto.convertor.BookDTOConvertor;
import by.grsu.bookMarket.repository.AuthorRepository;
import by.grsu.bookMarket.repository.BookRepository;
import by.grsu.bookMarket.service.api.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AuthorRepository authorRepository;
    private final AuthorDTOConvertor authorDTOConvertor;

    private final BookRepository bookRepository;
    private final BookDTOConvertor bookDTOConvertor;

    @Override
    public void addAuthor(AuthorCreationDTO authorDTO) {
        authorRepository.save(authorDTOConvertor.convertCreationDTOToEntity(authorDTO));
    }

    @Override
    public void deleteAuthor(String name) {
        authorRepository.deleteAuthorByName(name);
    }

    @Override
    public void addBook(BookCreationDTO bookDTO) {
        bookRepository.save(bookDTOConvertor.convertCreationDTOToEntity(bookDTO));
    }

    @Override
    public void removeBook(String name) {
        bookRepository.deleteBookByName(name);
    }
}
