package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Patron;

public class PatronDAOClass implements PatronDAO {
	private static final Connection conn = ConnectionManager.getConnection();
	private static final String SELECT_ALL_PATRONS = "SELECT * FROM patron";
	private static final String SELECT_PATRON_BY_ID = "SELECT * FROM patron WHERE patron_id=?";
	private static final String ADD_PATRON = "INSERT INTO patron(patron_id, first_name, last_name, username, password, account_frozen) values (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_PATRON = "UPDATE patron SET first_name = ?, last_name = ?, username = ?, password = ? WHERE patron_id=?";
	private static final String UPDATE_PATRON_STATUS = "UPDATE patron SET account_frozen = ? WHERE patron_id=?";
	private static final String DELETE_PATRON = "DELETE FROM patron WHERE patron_id=?";
	@Override
	public boolean addPatron(Patron p) {
		try (PreparedStatement pstmt = conn.prepareStatement(ADD_PATRON);){
			pstmt.setInt(1, p.getId());
			pstmt.setString(2, p.getFirst_name());
			pstmt.setString(3, p.getLast_name());
			pstmt.setString(4, p.getUsername());
			pstmt.setString(5, p.getPassword());
			pstmt.setBoolean(6, p.isAccount_frozen());
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
	public List<Patron> getAllPatrons() {
		List<Patron> patrons = new ArrayList<>();
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_PATRONS);
				ResultSet rs = pstmt.executeQuery();){
			while(rs.next()) {
				patrons.add(new Patron(rs.getInt("patron_id"),
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("username"),
						rs.getString("password"),
						rs.getBoolean("account_frozen")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return patrons;
	}

	@Override
	public Patron getPatronById(int id) {
		Patron patron = null;
		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_PATRON_BY_ID);) {
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				patron = new Patron(rs.getInt("patron_id"),
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("username"),
						rs.getString("password"),
						rs.getBoolean("account_frozen"));
				} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return patron;
	}

	@Override
	public boolean updatePatron(Patron p) {
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_PATRON);){
			pstmt.setString(1, p.getFirst_name());
			pstmt.setString(2, p.getLast_name());
			pstmt.setString(3, p.getUsername());
			pstmt.setString(4, p.getPassword());
			pstmt.setInt(5, p.getId());
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
	public boolean deletePatron(int id) {
		try (PreparedStatement pstmt = conn.prepareStatement(DELETE_PATRON);){
			pstmt.setInt(1, id);
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
	public boolean updatePatronStatus(int id, boolean status) {
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_PATRON_STATUS);){
			pstmt.setBoolean(1, status);
			pstmt.setInt(2, id);
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
