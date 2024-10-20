package com.hyvercode.spring.controller;

import com.hyvercode.spring.model.response.BookResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final List<BookResponse> bookResponses = Arrays.asList(new BookResponse(1,"Java Basic"),new BookResponse(2,"Spring Boot"));

    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookResponse> getBooks(){
        return bookResponses.stream().toList();
    }

    @GetMapping(value = "/{bookId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookResponse> getBook(@PathVariable("bookId") int bookId){
        return bookResponses.stream()
                .filter(bookResponse -> bookResponse.getBookId()==bookId)
                .toList();
    }
}
