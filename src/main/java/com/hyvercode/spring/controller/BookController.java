package com.hyvercode.spring.controller;

import com.hyvercode.spring.model.response.BookResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final List<BookResponse> bookResponses = Arrays.asList(new BookResponse(1,"Java Basic"),new BookResponse(2,"Spring Boot"));

    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookResponse> getBooks(){
        return bookResponses.stream().toList();
    }

    @GetMapping(value = "/{bookId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<BookResponse> getBook(@PathVariable("bookId") int bookId){
        List<BookResponse> list = bookResponses.stream()
                .filter(bookResponse -> bookResponse.getBookId() == bookId)
                .toList();

        if(list.isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book ID not found");
        }
        return list.stream().reduce((bookResponse, bookResponse2) ->
                BookResponse.builder()
                .bookId(bookResponse2.getBookId())
                .bookName(bookResponse2.getBookName())
                .build());
    }
}
