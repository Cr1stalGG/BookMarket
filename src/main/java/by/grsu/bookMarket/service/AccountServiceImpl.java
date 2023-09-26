package by.grsu.bookMarket.service;

import by.grsu.bookMarket.entity.Account;
import by.grsu.bookMarket.entity.Book;
import by.grsu.bookMarket.entity.BoughtBook;
import by.grsu.bookMarket.entity.dto.accountDTO.AccountAddAmountRequest;
import by.grsu.bookMarket.entity.dto.accountDTO.AccountMainInfoDTO;
import by.grsu.bookMarket.entity.dto.convertor.AccountDTOConvertor;
import by.grsu.bookMarket.entity.dto.convertor.BookDTOConvertor;
import by.grsu.bookMarket.entity.enumirations.RoleConstant;
import by.grsu.bookMarket.repository.AccountRepository;
import by.grsu.bookMarket.repository.BookRepository;
import by.grsu.bookMarket.repository.BoughtBookRepository;
import by.grsu.bookMarket.security.authDTO.AccountAuthRequest;
import by.grsu.bookMarket.security.authDTO.AccountAuthResponse;
import by.grsu.bookMarket.security.jwt.JwtService;
import by.grsu.bookMarket.service.api.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountDTOConvertor accountDTOConvertor;

    private final BookRepository bookRepository;
    private final BookDTOConvertor bookDTOConvertor;

    private final BoughtBookRepository boughtBookRepository;

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AccountAuthResponse registration(AccountAuthRequest accountDTO) {
        Account account = Account.builder()
                .mail(accountDTO.getMail())
                .password(passwordEncoder.encode(accountDTO.getPassword()))
                .role(RoleConstant.USER)
                .build();

        accountRepository.save(account);

        var jwtToken = jwtService.generateToken(account);

        return AccountAuthResponse.builder().token(jwtToken).build();
    }

    @Override
    public AccountAuthResponse authentication(AccountAuthRequest accountDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountDTO.getMail(), accountDTO.getPassword()));

        Account user = Optional.ofNullable(accountRepository.findAccountByMail(accountDTO.getMail())).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AccountAuthResponse.builder().token(jwtToken).build();
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

        if((book.getPrice() > account.getCash()))
            return "Buying a book failed. U have no money to do this.";

        account.setCash(account.getCash() - book.getPrice());
        account.getBoughtBooks().add(boughtBook);

        boughtBookRepository.save(boughtBook);
        accountRepository.save(account);

        return "Success";
    }

    @Override
    public String addAmount(AccountAddAmountRequest addAmountRequest) {
        Account account = accountRepository.findAccountByMail(addAmountRequest.getMail());

        account.setCash(account.getCash() + addAmountRequest.getAmount());

        accountRepository.save(account);

        return "Success";
    }
}
