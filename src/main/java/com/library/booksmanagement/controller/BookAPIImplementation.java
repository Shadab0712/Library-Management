package com.library.booksmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.booksmanagement.dto.BookDTO;
import com.library.booksmanagement.service.BookServiceImplementation;

@RestController
public class BookAPIImplementation implements BookManagementAPIContracts {

	@Autowired
	private BookServiceImplementation service;

	@PostMapping("/api/v1/book/")
	public ResponseEntity<String> createBook(@RequestBody BookDTO bookDTO) {
		service.createBook(bookDTO);
		return new ResponseEntity<String>("Book Created", HttpStatus.CREATED);
	}

	@GetMapping("/api/v1/book/{bookId}")
	public ResponseEntity<BookDTO> getBook(@PathVariable Long bookId) {
		BookDTO getBook = service.getBook(bookId);
		return new ResponseEntity<>(getBook, HttpStatus.OK);

	}

	@PutMapping("/api/v1/book/{bookId}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable Long bookId, @RequestBody BookDTO bookDTO) {
		BookDTO updateBook = service.updateBook(bookId, bookDTO);
		return new ResponseEntity<>(updateBook, HttpStatus.OK);

	}

	@DeleteMapping("/api/v1/book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
		service.deleteBook(bookId);
		return new ResponseEntity<>("Book Deleted", HttpStatus.OK);

	}

}
