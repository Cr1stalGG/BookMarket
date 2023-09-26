package by.grsu.bookMarket.controller;

import by.grsu.bookMarket.entity.dto.accountDTO.AccountAddAmountRequest;
import by.grsu.bookMarket.entity.dto.accountDTO.AccountMainInfoDTO;
import by.grsu.bookMarket.service.AccountServiceImpl;
import by.grsu.bookMarket.service.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts/{mail}")
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceImpl accountService;

    @GetMapping()
    public AccountMainInfoDTO getAccount(@PathVariable String mail){
        return accountService.getMainInfo(mail);
    }

    @PostMapping("/amount")

    public String addAmount(@RequestBody AccountAddAmountRequest addAmountRequest){
        return accountService.addAmount(addAmountRequest);
    }

    @PostMapping("/book/{bookName}")
    public String buyBook(@PathVariable String mail, @PathVariable String bookName){
        return accountService.buyBook(mail, bookName);
    }
}
