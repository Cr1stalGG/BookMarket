package by.grsu.bookMarket.repository;

import by.grsu.bookMarket.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorByName(String name);
    void deleteAuthorByName(String name);
}
