package com.library.booksmanagement.service;

import com.library.booksmanagement.dto.BookDTO;

public interface BookManagementServiceContracts {

	public boolean createBook(BookDTO bookDTO);

	public BookDTO getBook(Long bookId);

	public BookDTO updateBook(Long bookId , BookDTO bookDTO);

	public boolean deleteBook(Long bookId);
}
