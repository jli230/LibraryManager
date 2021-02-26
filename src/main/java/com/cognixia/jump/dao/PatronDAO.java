package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Patron;

public interface PatronDAO {
	boolean addPatron(Patron p);
	List<Patron> getAllPatrons();
	Patron getPatronById(int id);
	boolean updatePatron(Patron p);
	boolean updatePatronStatus(int id, boolean status);
	boolean deletePatron(int id);
}
