package com.library.booksmanagement.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.booksmanagement.model.Book;

@Repository
public class BookRepositoryImplementation implements BookManagementRepositoryContracts {

	@Autowired
	private BookManagementRepository repository;

	@Override
	public boolean insertIntoBookTable(Book book) {
		repository.save(book);
		return true;
	}

	@Override
	public Book selectFromBookTable(Long bookId) {
		Optional<Book> bookOptional = repository.findById(bookId);
		if (bookOptional.isPresent()) {
			Book book = bookOptional.get();
			return book;
		}

		return null;
	}

	@Override
	public Book updateIntoBookTable(Long bookId, Book book) {
		Book bookUpdate = repository.save(book);
		return bookUpdate;
	}

	@Override
	public boolean deleteFromBookTable(Long bookId) {
		repository.deleteById(bookId);
		return true;
	}

}
