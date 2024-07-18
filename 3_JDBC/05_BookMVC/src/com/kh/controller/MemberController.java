package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.Serverinfo;

public class MemberController {
	
	
	
	
	         //4.회원가입
			public boolean registerMember(String memberId,String memberPwd,String memberName) {
				// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
				// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
				// 실패하면 "회원가입에 실패했습니다." 출력
				try {
					Class.forName(Serverinfo.DRIVER_NAME);
					Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
					String query="INSERT INTO member(member_id,member_pwd,member_name) VALUES(?,?,?)";
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(1, memberId);
					ps.setString(2, memberPwd);
					ps.setString(3, memberName);
					ps.executeUpdate();
					
					return true;
					
				
				} catch (ClassNotFoundException | SQLException e) {
					
					System.out.println();
				}
				
				
				return false;
				
			}

			// 5. 로그인
			public String  login(String memberId,String memberPwd) {
				// 아이디, 비밀번호를 사용자한테 입력 받아 
				
				try {
					Class.forName(Serverinfo.DRIVER_NAME);
					Connection conn= DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
					String query="SELECT member_name FROM member WHERE member_id=? AND member_pwd=?";
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(1, memberId);
					ps.setString(2, memberPwd);
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()) {
						return rs.getString("member_name");
					}else {
					  return null;
					}
				} catch (SQLException | ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				return null;
				
				// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후 memberMenu() 호출
				// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후
			}

}
