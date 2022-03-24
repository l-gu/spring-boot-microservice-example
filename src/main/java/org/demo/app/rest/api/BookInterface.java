package org.demo.app.rest.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.demo.app.dto.BookDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
public interface BookInterface  {

    // @GetMapping("/") // ("/api/books/")
    @GetMapping() // ("/api/books")
    List<BookDTO> getAllBooks();

    @GetMapping("/{id}")
    Optional<BookDTO> getBook(@PathVariable Integer id);

    //@PostMapping("/") // ("/api/books/")
    @PostMapping()
    public void createBook(@RequestBody @Valid BookDTO book);
}
