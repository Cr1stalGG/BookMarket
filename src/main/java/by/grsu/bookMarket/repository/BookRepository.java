package by.grsu.bookMarket.repository;

import by.grsu.bookMarket.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByNameLike(String name);
    Book findBookByName(String name);
    void deleteBookByName(String name);
}
