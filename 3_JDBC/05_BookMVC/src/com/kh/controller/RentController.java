package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
				conn.close();
				ps.close();
				rs.close();	
				return memberNo;
			}
			conn.close();
			ps.close();
			rs.close();	
		 return 0;
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
	public boolean rentCheck( int bkNo) {
		
		boolean check= true;
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
			Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
			String query="SELECT * FROM rent WHERE  rent_book_no = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
		//	ps.setInt(1, memberNo);
			ps.setInt(1, bkNo);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			
				check= false;
			}
			conn.close();
			ps.close();
			rs.close();	
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return check;
	}
	
	public boolean bkNumCheck(int bkNo) {
		boolean check = false;
		try {
		Class.forName(Serverinfo.DRIVER_NAME);
		Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
		String query="SELECT * FROM book WHERE bk_no=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, bkNo);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			check=true;
		}
		conn.close();
		ps.close();
		rs.close();	
			
		} catch (Exception e) {
			
		}
		return check;
	}
	
	
	
	public boolean rentBook(int memberNo ,int bkNo) {
		// printBookAll 메서드 호출하여 전체 책 조회 출력 후
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		boolean check=false;
		try {
			if(bkNumCheck(bkNo)) {
			Class.forName(Serverinfo.DRIVER_NAME);
			Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
			String query="INSERT INTO rent(rent_mem_no,rent_book_no) VALUES(?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
		    ps.setInt(1, memberNo);
			ps.setInt(2, bkNo);
			
			if(ps.executeUpdate() !=0) {
				check=true;
				
			}else {
				check=false;
				conn.close();
				ps.close();
			
			}
			}else {
				check=false;
				
			}	
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return check;
		
	}
	
	public void printRentBook(int memberNo) {
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
			Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
			String query="SELECT rent_no,bk_title,bk_author,rent_date,adddate(rent_date,INTERVAL 7 DAY) FROM rent join book ON(rent_book_no = bk_no) WHERE rent_mem_no = ?";
			PreparedStatement ps = conn.prepareStatement(query);
		   
		    ps.setInt(1, memberNo);
		    ResultSet rs = ps.executeQuery();
		    
		    while(rs.next()) {
		    int rentNo = rs.getInt("rent_no");	
		    String bkTitle =	rs.getString("bk_title");
		    String bkAuthor= rs.getString("bk_author");
		    Date rentDate = rs.getDate("rent_date");
		    Date lastDate=rs.getDate("adddate(rent_date,INTERVAL 7 DAY)");
		    	
		    	System.out.println("대여 번호 : " + rentNo + " / 책 제목 : "+bkTitle+" / 책 저자 : "+ bkAuthor+" / 대여 날짜 : "+ rentDate + " / 반납 기한 : "+ lastDate);
		    	
		    	
		    }
		    conn.close();
			ps.close();
			rs.close();	
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}	
	
	
	public boolean deleteRent(int rentNo) {
		// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
		// 실패하면 "대여를 취소하는데 실패했습니다." 출력
		boolean check =false;
		try {	
		Class.forName(Serverinfo.DRIVER_NAME);
		Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
		String query="DELETE FROM rent WHERE  rent_no =?";
		PreparedStatement ps = conn.prepareStatement(query);
	//	ps.setInt(1, memberNo);
		ps.setInt(1, rentNo);
		
		if(ps.executeUpdate()==1) {
			check = true;
			
		}
		conn.close();
		ps.close();
	
	   
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return check;
	
	}
	// 4. 회원탈퇴
	
	public boolean deleteMember(int memberNo) {
		 boolean check= false;
		try {
       
			Class.forName(Serverinfo.DRIVER_NAME);
			Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
			String query="SELECT * FROM rent WHERE rent_mem_no=? ";
			String query2="DELETE FROM member WHERE member_no=?";
			PreparedStatement ps = conn.prepareStatement(query);
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps.setInt(1,memberNo );
			ps2.setInt(1,memberNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				return check;
			}else {
				ps2.executeUpdate();
				check=true;
			}
			conn.close();
			ps.close();
			rs.close();	
			
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return check;
		
	}
		
	
	
	

}
