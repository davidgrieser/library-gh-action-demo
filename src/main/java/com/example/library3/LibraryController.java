package com.example.library3;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    BookService bookService;

    public LibraryController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("")
    public String rootPage() {
        return "{\"message\": \"Welcome to the Library\"}";
    }

    @PostMapping("books")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBooks(@RequestBody BookDto bookDto){
        this.bookService.create(bookDto);
    }

    @GetMapping("books")
    public List<BookDto> getBooks(){
        return this.bookService.fetchAll();
    }

    @GetMapping("books/{bookTitle}")
    public BookDto getBookByName(@PathVariable String bookTitle) {
        return this.bookService.findByTitle(bookTitle);
    }
}
