package com.library.booksmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.library.booksmanagement.model.Book;

public interface BookManagementRepository extends CrudRepository <Book , Long>{

}
