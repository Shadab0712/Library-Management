package com.library.booksmanagement.repository;

import com.library.booksmanagement.model.Book;

public interface BookManagementRepositoryContracts {

	public boolean insertIntoBookTable(Book book);

	public Book selectFromBookTable(Long bookId);

	public Book updateIntoBookTable(Long bookId, Book book);

	public boolean deleteFromBookTable(Long bookId);
}
