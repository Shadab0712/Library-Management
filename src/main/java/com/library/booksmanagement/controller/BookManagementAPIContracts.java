package com.library.booksmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.booksmanagement.dto.BookDTO;

public interface BookManagementAPIContracts {
	
	@PostMapping("/api/v1/book/")
	public ResponseEntity<String> createBook(@RequestBody BookDTO bookDTO );
	
	@GetMapping("/api/v1/book/{bookId}")
	public ResponseEntity<BookDTO> getBook(@PathVariable Long bookId);
	
	@PutMapping("/api/v1/book/{bookId}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable Long bookId , @RequestBody BookDTO bookDTO );
	
	@DeleteMapping("/api/v1/book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Long bookId);

}
