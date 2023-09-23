package by.grsu.bookMarket.service;

import by.grsu.bookMarket.entity.Account;
import by.grsu.bookMarket.entity.Book;
import by.grsu.bookMarket.entity.BoughtBook;
import by.grsu.bookMarket.entity.dto.accountDTO.AccountMainInfoDTO;
import by.grsu.bookMarket.entity.dto.convertor.AccountDTOConvertor;
import by.grsu.bookMarket.entity.dto.convertor.BookDTOConvertor;
import by.grsu.bookMarket.repository.AccountRepository;
import by.grsu.bookMarket.repository.BookRepository;
import by.grsu.bookMarket.repository.BoughtBookRepository;
import by.grsu.bookMarket.security.authDTO.AccountAuthRequest;
import by.grsu.bookMarket.security.authDTO.AccountAuthResponse;
import by.grsu.bookMarket.service.api.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountDTOConvertor accountDTOConvertor;

    private final BookRepository bookRepository;
    private final BookDTOConvertor bookDTOConvertor;

    private final BoughtBookRepository boughtBookRepository;

    @Override
    public AccountAuthResponse registration(AccountAuthRequest accountDTO) {
        return null;
    }

    @Override
    public AccountAuthResponse authentication(AccountAuthRequest accountDTO) {
        return null;
    }

    @Override
    public AccountMainInfoDTO getMainInfo(String mail) {
        return accountDTOConvertor.convertEntityToDTO(accountRepository.findAccountByMail(mail));
    }

    @Override
    public String buyBook(String mail, String bookName) {
        Book book = bookRepository.findBookByName(bookName);
        Account account = accountRepository.findAccountByMail(mail);
        BoughtBook boughtBook = bookDTOConvertor.convertBookToBoughtBook(book);

        if((book.getPrice() > account.getAmount()))
            return "Buying a book failed. U have no money to do this.";

        if(!book.buyOne())
            bookRepository.deleteBookByName(bookName);

        account.buyBook(book.getPrice(), boughtBook);

        boughtBookRepository.save(boughtBook);
        accountRepository.save(account);

        return "Success";
    }
}
