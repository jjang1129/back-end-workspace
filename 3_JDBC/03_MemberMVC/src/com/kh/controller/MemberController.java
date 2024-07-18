package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.Member;

import config.Serverinfo;

public class MemberController {
	
	
	

		
	public boolean signUp(String id, String name, String password) {

		 boolean check=false;
		// 회원가입 기능 구현! 
		// -> 아이디가 기존에 있는지 체크 여부!
		// -> member 테이블에 데이터 추가! 
		
		try {
	Class.forName(Serverinfo.DRIVER_NAME);
	Connection conn = DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
			String query = "INSERT INTO member (id,password,name) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, name);
			
			
			if(ps.executeUpdate() == 1) {
			
				check=true;
				ps.close();
				conn.close();
				
				
			}
				
			
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println();
		}
		
		
		
		
		return check;
		
		
		
		

	}
	
	public String login(String id, String password) {

		// 로그인 기능 구현! 
		// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!
		String name=null;
		
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
			Connection conn = DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
					String query = "SELECT * FROM member WHERE id=? AND password=?";
					PreparedStatement ps = conn.prepareStatement(query);
					
					ps.setString(1, id);
					ps.setString(2, password);
					
					ResultSet rs = ps.executeQuery();
					
					
					if(rs.next()) {
						
						name = rs.getString("name");
						ps.close();
						rs.close();
						
					}	
					
					
					
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				}
		return name;
				
				
		
				
				
				
		
		
		
	}
	
	public boolean changePassword(String id,String newPassword,String password) {
		boolean check = false;
		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
			Connection conn = DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
					String query = "UPDATE member SET password=? WHERE id=?";
					PreparedStatement ps = conn.prepareStatement(query);
					
				
					
					if( login(id, password) != null) {
						ps.setString(1, newPassword);
						ps.setString(2, id);
						
						ps.executeUpdate();
						
						check = true;
					} 
					
					ps.close();
					conn.close();
					
					
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				} 
		
		
				
		
				return check;
		
		
		
		
		

	}
	
	public void changeName(String id, String password, String name1) {

		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 
		
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
			Connection conn = DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
					String query = "UPDATE member SET name=? WHERE id=?";
					PreparedStatement ps = conn.prepareStatement(query);
					
				
										
						ps.setString(1, name1);
						ps.setString(2, id);						
						ps.executeUpdate();
						
						ps.close();
						conn.close();
						
						
					System.out.println("이름 변경에 성공하셨습니다");
					
				
					
					
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				} 
				
		
				
		
		
	}
	
}









