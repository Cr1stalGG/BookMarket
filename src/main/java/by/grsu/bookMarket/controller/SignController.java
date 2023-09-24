package by.grsu.bookMarket.controller;

import by.grsu.bookMarket.security.authDTO.AccountAuthRequest;
import by.grsu.bookMarket.security.authDTO.AccountAuthResponse;
import by.grsu.bookMarket.service.AccountServiceImpl;
import by.grsu.bookMarket.service.AddAminService_Test;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignController {
    private final AccountServiceImpl accountService;
    private final AddAminService_Test addAminService;

    @PostMapping("/up")
    public AccountAuthResponse registration(@RequestBody AccountAuthRequest request){
        return accountService.registration(request);
    }

    @PostMapping("/in")
    public AccountAuthResponse authentication(@RequestBody AccountAuthRequest request){
        return accountService.authentication(request);
    }

    @PostMapping("/addAdmin")
    public void addAdmin(){
        addAminService.addAdmin();
    }
}
