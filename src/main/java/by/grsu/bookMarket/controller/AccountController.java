package by.grsu.bookMarket.controller;

import by.grsu.bookMarket.entity.dto.accountDTO.AccountMainInfoDTO;
import by.grsu.bookMarket.entity.dto.authorDTO.AuthorCreationDTO;
import by.grsu.bookMarket.entity.dto.bookDTO.BookCreationDTO;
import by.grsu.bookMarket.service.AccountServiceImpl;
import by.grsu.bookMarket.service.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts/{mail}")
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceImpl accountService;
    private final AdminServiceImpl adminService;

    @GetMapping()
    public AccountMainInfoDTO getAccount(@PathVariable String mail){
        return accountService.getMainInfo(mail);
    }

    @PostMapping("/buy-book/{bookName}")
    public String buyBook(@PathVariable String mail, @PathVariable String bookName){
        return accountService.buyBook(mail, bookName);
    }

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
