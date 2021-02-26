package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Book;
import com.cognixia.jump.model.Patron;

public class BookDAOClass implements BookDAO {
	private static final Connection conn = ConnectionManager.getConnection();
	private static final String VIEW_ALL_BOOKS = "SELECT * FROM patron";//dummy line, code can be performed in jsp
	private static final String SELECT_BOOK_BY_ISBN = "SELECT * FROM book WHERE isbn=?";
	private static final String ADD_BOOK = "INSERT INTO book(isbn, title, descr, rented, added_to_library) values (?, ?, ?, ?, ?)";
	private static final String UPDATE_BOOK = "UPDATE book SET title = ?, descr = ? WHERE isbn=?";
	private static final String DELETE_BOOK = "DELETE FROM book WHERE isbn=?";
	private static final String RENTED_STATUS = "UPDATE book SET rented = ? WHERE isbn=?";
	@Override
	public boolean addBook(Book b) {
		try (PreparedStatement pstmt = conn.prepareStatement(ADD_BOOK);){
			pstmt.setString(1, b.getIsbn());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getDescription());
			pstmt.setBoolean(4, b.isRented());
			pstmt.setDate(5, java.sql.Date.valueOf(b.getAdded_to_library()));
			if (pstmt.executeUpdate() >0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookById(int isbn) {
		Book book = null;
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_BOOK_BY_ISBN);) {
				pstmt.setInt(1, isbn);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				book = new Book(rs.getString("isbn"),
						rs.getString("title"), 
						rs.getString("descr"), 
						rs.getBoolean("rented"),
						rs.getDate("added_to_library").toLocalDate());
				} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
	}

	@Override
	public boolean updateBook(Book b) {
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_BOOK);){
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getDescription());
			pstmt.setString(3, b.getIsbn());
			if (pstmt.executeUpdate() >0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBook(int isbn) {
		try (PreparedStatement pstmt = conn.prepareStatement(DELETE_BOOK);){
			pstmt.setInt(1, isbn);
			if (pstmt.executeUpdate() >0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBookStatus(int isbn, boolean status) {
		try (PreparedStatement pstmt = conn.prepareStatement(RENTED_STATUS);){
			pstmt.setBoolean(1, status);
			pstmt.setInt(2, isbn);
			if (pstmt.executeUpdate() >0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
