package by.grsu.bookMarket.controller;

import by.grsu.bookMarket.entity.dto.accountDTO.AccountAddAmountRequest;
import by.grsu.bookMarket.entity.dto.accountDTO.AccountMainInfoDTO;
import by.grsu.bookMarket.service.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts/{id}")
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceImpl accountService;

    @GetMapping()
    public AccountMainInfoDTO getAccount(@PathVariable long id){
        return accountService.getMainInfo(id);
    }

    @PostMapping("/amount")

    public String addAmount(@RequestBody AccountAddAmountRequest addAmountRequest){
        return accountService.addAmount(addAmountRequest);
    }

    @PostMapping("/book/{bookName}")
    public String buyBook(@PathVariable long id, @PathVariable String bookName){
        return accountService.buyBook(id, bookName);
    }
}
