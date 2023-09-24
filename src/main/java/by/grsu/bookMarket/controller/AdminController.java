package by.grsu.bookMarket.controller;

import by.grsu.bookMarket.entity.dto.authorDTO.AuthorCreationDTO;
import by.grsu.bookMarket.entity.dto.bookDTO.BookCreationDTO;
import by.grsu.bookMarket.service.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {
    private final AdminServiceImpl adminService;

    @PostMapping("/add-author")
    public void addAuthor(@RequestBody AuthorCreationDTO authorDTO){
        adminService.addAuthor(authorDTO);
    }

    @DeleteMapping("/delete-author/{authorName}")
    public void deleteAuthor(@PathVariable String authorName){
        adminService.deleteAuthor(authorName);
    }

    @PostMapping("/add-book")
    public void addBook(@RequestBody BookCreationDTO bookDTO){
        adminService.addBook(bookDTO);
    }

    @DeleteMapping("/delete-book/{bookName}")
    public void deleteBook(@PathVariable String bookName){
        adminService.deleteBook(bookName);
    }
}
