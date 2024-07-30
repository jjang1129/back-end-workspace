package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.Serverinfo;

public class signUpDAO {
	
    public signUpDAO(){
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
    	
	
	public void insertSignUp() throws SQLException {
		
		Connection conn = connect();
		
	     String query = "INSERT INTO signup(id,password,name) VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, query);
		ps.setString(2, query);
		ps.setString(3, query);
		
		
		
		
		
	}
	
	
	
	
	
	
    }

