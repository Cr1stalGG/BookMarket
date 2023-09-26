package by.grsu.bookMarket.controller;

import by.grsu.bookMarket.entity.dto.bookDTO.BookMainInfoDTO;
import by.grsu.bookMarket.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImpl bookService;

    @GetMapping("/{name}")
    public List<BookMainInfoDTO> find(@PathVariable String name){
        return bookService.find(name);
    }



}
