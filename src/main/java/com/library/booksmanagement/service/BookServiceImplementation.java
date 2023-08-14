package com.library.booksmanagement.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.booksmanagement.dto.BookDTO;
import com.library.booksmanagement.model.Book;
import com.library.booksmanagement.repository.BookRepositoryImplementation;

@Service
public class BookServiceImplementation implements BookManagementServiceContracts {

	@Autowired
	private BookRepositoryImplementation repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean createBook(BookDTO bookDTO) {
		Book createBook = modelMapper.map(bookDTO, Book.class);
		repository.insertIntoBookTable(createBook);
		return true;
	}

	@Override
	public BookDTO getBook(Long bookId) {
		Book getBook = repository.selectFromBookTable(bookId);
		BookDTO bookDTO = modelMapper.map(getBook, BookDTO.class);
		return bookDTO;
	}

	@Override
	public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
		Book bookFromDatabase = repository.selectFromBookTable(bookId);
		bookFromDatabase.setAuthor(bookDTO.getAuthor());
		Book updateIntoBookTable = repository.updateIntoBookTable(bookId, bookFromDatabase);
		BookDTO newBookDTO = modelMapper.map(updateIntoBookTable, BookDTO.class);
		return newBookDTO;
	}

	@Override
	public boolean deleteBook(Long bookId) {
		repository.deleteFromBookTable(bookId);
		return true;
	}

}
