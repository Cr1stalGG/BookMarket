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

    @PostMapping("/author")
    public void addAuthor(@RequestBody AuthorCreationDTO authorDTO){
        adminService.addAuthor(authorDTO);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable long id){
        adminService.deleteAuthor(id);
    }

    @PostMapping("/book")
    public void addBook(@RequestBody BookCreationDTO bookDTO){
        adminService.addBook(bookDTO);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable long id){
        adminService.deleteBook(id);
    }
}