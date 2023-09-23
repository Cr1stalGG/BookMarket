package by.grsu.bookMarket.repository;

import by.grsu.bookMarket.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
   @Query(value = "select b from book b where b.name like %:#{#query}% order by b.name", nativeQuery = true) //TODO add query to find all books by smth looks like name and grouped by name
    List<Book> find(String query);
    Book findBookByName(String name);
    void deleteBookByName(String name);
    //TODO find all by author
}
