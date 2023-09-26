package by.grsu.bookMarket.entity.dto.convertor;

import by.grsu.bookMarket.entity.Account;
import by.grsu.bookMarket.entity.dto.accountDTO.AccountMainInfoDTO;
import by.grsu.bookMarket.security.authDTO.AccountAuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountDTOConvertor {
    private final BoughtBookDTOConvertor boughtBookDTOConvertor;

    public Account convertAuthRequestToEntity(AccountAuthRequest accountDTO){
        return Account.builder()
                .mail(accountDTO.getMail())
                .password(accountDTO.getPassword())
                .build();
    }

    public AccountMainInfoDTO convertEntityToDTO(Account account){
        return AccountMainInfoDTO.builder()
                .mail(account.getMail())
                .amount(account.getCash())
                .boughtBooks(account.getBoughtBooks().stream().map(boughtBookDTOConvertor :: convertEntityToDTO).toList())
                .build();
    }
}
