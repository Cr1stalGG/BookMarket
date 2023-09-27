package by.grsu.bookMarket.service;

import by.grsu.bookMarket.entity.dto.authorDTO.AuthorCreationDTO;
import by.grsu.bookMarket.entity.dto.bookDTO.BookCreationDTO;
import by.grsu.bookMarket.entity.dto.convertor.AuthorDTOConvertor;
import by.grsu.bookMarket.entity.dto.convertor.BookDTOConvertor;
import by.grsu.bookMarket.repository.AuthorRepository;
import by.grsu.bookMarket.repository.BookRepository;
import by.grsu.bookMarket.service.api.AdminService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public void addAuthor(AuthorCreationDTO authorDTO) {
        authorRepository.save(AuthorDTOConvertor.convertCreationDTOToEntity(authorDTO));
    }

    @Override
    public void deleteAuthor(long id) {
        authorRepository.deleteAuthorById(id);
    }

    @Override
    public void addBook(BookCreationDTO bookDTO) {
        bookRepository.save(BookDTOConvertor.convertCreationDTOToEntity(bookDTO));
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteBookById(id);
    }
}
