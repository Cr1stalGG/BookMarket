package by.grsu.bookMarket.repository;

import by.grsu.bookMarket.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByMail(String mail);
    Account findAccountById(long id);

}
