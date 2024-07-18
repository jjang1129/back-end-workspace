package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.Serverinfo;

public class RentController {
	
	
	//멤버 번호 불러오는 메서드 
	public int memberNo(String memberId,String memberPwd) {
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
			Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
			String query="SELECT * FROM member WHERE member_id=? AND member_pwd=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, memberId);
			
			ps.setString(2, memberPwd);
			
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				int memberNo= rs.getInt("member_no");
				return memberNo;
			}
		 return 0;
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
	public boolean rentBook(int memberNo ,int bkNo) {
		// printBookAll 메서드 호출하여 전체 책 조회 출력 후
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		boolean check=false;
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
			Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
			String query="INSERT INTO rent(rent_book_no) VALUES(?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
		
			ps.setInt(1, bkNo);
			
			ps.executeUpdate();
			
			if(ps.executeUpdate() !=0) {
				check=true;
				return check;
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return check;
		
	}
	
	

}
