package by.grsu.bookMarket.repository;

import by.grsu.bookMarket.entity.BoughtBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoughtBookRepository extends JpaRepository<BoughtBook, Long> {
    BoughtBook findBoughtBookByName(String name);
    //TODO find all by author
}
