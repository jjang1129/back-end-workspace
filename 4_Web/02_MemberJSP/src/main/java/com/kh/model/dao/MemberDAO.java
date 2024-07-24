package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.controller.RegisterServlet;
import com.kh.model.vo.Member;

import config.Serverinfo;



public class MemberDAO {
	
	
	
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/member","root","qwer1234");
	}
	

	
	
	
	// 회원가입 - member 스키마의 member 테이블 
	public void registerMember(String id,String password, String name) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/member","root","qwer1234");
		  String query ="INSERT INTO member (id,password,name) VALUES(?,?,?)";
		  PreparedStatement ps = conn.prepareStatement(query);
		  ps.setString(1, id);
		
		  ps.setString(2, password);
		  ps.setString(3, name);
		  ps.executeUpdate();
		  
		  ps.close();
		  conn.close();
		  
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 회원 아이디 존재 유무 있으면 true 없으면 false 
	public boolean checkMember(String id) {
		
		boolean check = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/member","root","qwer1234");
		  String query ="SELECT * FROM member WHERE id=?";
		  PreparedStatement ps = conn.prepareStatement(query);
		  ps.setString(1, id);
		
		
		ResultSet rs =ps.executeQuery();
		
		if(rs.next()) {
			
			check=true;
			
		}
		  ps.close();
		  conn.close();
		  rs.close();
		  
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	// 전체 회원 보기
	public ArrayList<Member> viewMember() {
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/member","root","qwer1234");
		  String query ="SELECT * FROM member";
		  PreparedStatement ps = conn.prepareStatement(query);
		
		
		
		ResultSet rs =ps.executeQuery();
		
		while(rs.next()) {
			
			Member member = new Member();
			
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPassword(rs.getString("password"));
			
			list.add(member);
			
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
		 
		  
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
		
	};
	// 해당 회원 1명 조회 
	
public Member searchMember(String id) {
		
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/member","root","qwer1234");
		  String query ="SELECT * FROM member WHERE id=?";
		  PreparedStatement ps = conn.prepareStatement(query);
		  
		
		  ps.setString(1, id);
		
		
		ResultSet rs =ps.executeQuery();
		
		
		Member member = null;
		
		
		if(rs.next()) {
			
			
			member = new Member();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPassword(rs.getString("password"));
			
			
			
		}
		rs.close();
		ps.close();
		conn.close();
		
		return member;
		 
		  
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	};
	
	

}
