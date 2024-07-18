package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import config.Serverinfo;

public class BookController {

	
	
	
	
	
	// 1. 전체 책 조회
		public void printBookAll() {
			
			try {
				Class.forName(Serverinfo.DRIVER_NAME);
				Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
				String query="SELECT * FROM book";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ResultSet rs =ps.executeQuery();
				
				while(rs.next()) {
				int bkNo =	rs.getInt("bk_no");
				String title =rs.getString("bk_title");
				String author =rs.getString("bk_author");
				int price = rs.getInt("bk_price");
				int pubNo = rs.getInt("bk_pub_no");
				
					
				System.out.println("도서번호 : "+bkNo+". " +"제목: "+ title +" / 저자: "+ author + " / 가격: "+ price +" / 출판사번호: "+ pubNo);	
					
				}
				
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		public boolean bookCheck(String title,String author) {
			
			boolean check = true;
			try {Class.forName(Serverinfo.DRIVER_NAME);
				Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
				String query="SELECT * FROM book WHERE bk_title=? AND bk_author=?";
				
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, title);
				ps.setString(2, author);
				
				ResultSet rs = ps.executeQuery();
				
				//있으면 false (불가) 
				if(rs.next()) {
					check=false;
					return check;
				}
				
						
			} catch ( Exception e) {
				
				e.printStackTrace();
			}
			
			return check;
		}
		
		public void registerBook(String title,String author) {
			// 책 제목, 책 저자를 사용자한테 입력 받아
			// 기존 제목 , 저자 있으면 등록 안되게 
			// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
			// 실패하면 "책을 등록하는데 실패했습니다." 출력
			
			try {
				Class.forName(Serverinfo.DRIVER_NAME);
				Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
				String query="INSERT INTO book(bk_title,bk_author) VALUES(?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
			if(bookCheck(title,author)) {	
				ps.setString(1, title);
				ps.setString(2, author);
				ps.executeUpdate();
				System.out.println("성공적으로 책을 등록했습니다.");
			}else {
				System.out.println("책을 등록하는데 실패했습니다.");
				
			
			}
				
								
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
					
		}
		// 3. 책 삭제
		public void sellBook(int bkNo) {
			// printBookAll로 전체 책 조회를 한 후
			// 삭제할 책 번호 선택을 사용자한테 입력 받아
			// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
			// 실패하면 "책을 삭제하는데 실패했습니다." 출력
			try {
				Class.forName(Serverinfo.DRIVER_NAME);
				Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
				String query="DELETE FROM book WHERE bk_no=?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, bkNo);
				ps.executeUpdate();
				if(ps.executeUpdate()==1) {
					System.out.println("책을 삭제하는데 실패했습니다");
				} else {
					System.out.println("책을 삭제하는데 성공했습니다");
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		

}
