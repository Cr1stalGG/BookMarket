package by.grsu.bookMarket.service;

import by.grsu.bookMarket.entity.dto.accountDTO.AccountMainInfoDTO;
import by.grsu.bookMarket.entity.dto.convertor.AccountDTOConvertor;
import by.grsu.bookMarket.repository.AccountRepository;
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
    public void buyBook(String bookName) {

    }
}
