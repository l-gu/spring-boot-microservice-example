package org.demo.app.rest.api.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.demo.app.dto.BookDTO;
import org.demo.app.rest.api.BookInterface;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController implements BookInterface {

	@Override
	public List<BookDTO> getAllBooks() {
		List<BookDTO> list = new LinkedList<>();
		list.add(new BookDTO(1,"Germinal"));
		list.add(new BookDTO(2,"Tarzan"));
		return list;
	}

	@Override
	public Optional<BookDTO> getBook(Integer id) {
		return Optional.of(new BookDTO(1,"Germinal"));
	}

	@Override
	public void createBook(@Valid BookDTO book) {
	}

}
