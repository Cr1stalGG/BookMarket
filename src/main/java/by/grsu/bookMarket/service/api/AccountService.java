package by.grsu.bookMarket.service.api;

import by.grsu.bookMarket.entity.dto.accountDTO.AccountMainInfoDTO;
import by.grsu.bookMarket.security.authDTO.AccountAuthRequest;
import by.grsu.bookMarket.security.authDTO.AccountAuthResponse;

public interface AccountService {
    AccountAuthResponse registration(AccountAuthRequest accountDTO);
    AccountAuthResponse authentication(AccountAuthRequest accountDTO);
    AccountMainInfoDTO getMainInfo(String mail);
    String buyBook(String mail, String bookName);
}