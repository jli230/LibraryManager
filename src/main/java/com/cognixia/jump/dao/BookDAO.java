package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Book;

public interface BookDAO {
	boolean addBook(Book b);
	List<Book> getAllBooks();
	Book getBookById(int isbn);
	boolean updateBook(Book b);
	boolean deleteBook(int isbn);
	boolean updateBookStatus(int isbn, boolean status);
}
