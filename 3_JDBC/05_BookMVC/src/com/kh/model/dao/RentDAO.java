package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.Serverinfo;

public class RentDAO {

	public RentDAO(){
		
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
		
	}
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void close(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException {
		close(ps,conn);
		rs.close();
	}
	
	
	// 대여한 책이 있는지 조회 
	 
	public boolean checkRentBook(int no) throws SQLException {
		Connection conn= connect();
		
		String query = "SELECT * FROM rent WHERE rent_book_no=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, no);		
		
		ResultSet rs = ps.executeQuery();
		
		boolean check=rs.next();
		
		close(rs, ps, conn);
		
		return check;
				
		
	}
	
	
	
	
}
