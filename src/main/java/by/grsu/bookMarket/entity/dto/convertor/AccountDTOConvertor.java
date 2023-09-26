package by.grsu.bookMarket.entity.dto.convertor;

import by.grsu.bookMarket.entity.Account;
import by.grsu.bookMarket.entity.dto.accountDTO.AccountMainInfoDTO;
import by.grsu.bookMarket.security.authDTO.AccountAuthRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountDTOConvertor {
    public Account convertAuthRequestToEntity(AccountAuthRequest source){
        return Account.builder()
                .mail(source.getMail())
                .password(source.getPassword())
                .build();
    }

    public AccountMainInfoDTO convertEntityToDTO(Account source){
        return AccountMainInfoDTO.builder()
                .mail(source.getMail())
                .amount(source.getCash())
                .boughtBooks(source.getBoughtBooks().stream().map(BoughtBookDTOConvertor::convertEntityToDTO).toList())
                .build();
    }
}
