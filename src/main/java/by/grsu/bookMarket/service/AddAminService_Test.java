package by.grsu.bookMarket.service;

import by.grsu.bookMarket.entity.Account;
import by.grsu.bookMarket.entity.enumirations.Role;
import by.grsu.bookMarket.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddAminService_Test {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public void addAdmin(){
        Account account = Account.builder()
                .mail("admin")
                .password(passwordEncoder.encode("admin"))
                .role(Role.ADMIN)
                .build();

        accountRepository.save(account);
    }
}
