package com.cognixia.jump.model;

import java.time.LocalDate;
import java.util.Date;

public class Book {
	private String isbn;
	private String title;
	private String description;
	private boolean rented;
	private LocalDate added_to_library;
	public Book(String isbn, String title, String description, boolean rented, LocalDate added_to_library) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.rented = rented;
		this.added_to_library = added_to_library;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isRented() {
		return rented;
	}
	public void setRented(boolean rented) {
		this.rented = rented;
	}
	public LocalDate getAdded_to_library() {
		return added_to_library;
	}
	public void setAdded_to_library(LocalDate added_to_library) {
		this.added_to_library = added_to_library;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", description=" + description + ", rented=" + rented
				+ ", added_to_library=" + added_to_library + "]";
	}
	
}
