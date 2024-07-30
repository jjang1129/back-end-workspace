package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kh.model.vo.Member;

import config.Serverinfo;

@Repository
public class MemberDAO {

public MemberDAO(){
		
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
	
	//DAO 개발할 때 중요한 건 
	// 매개변수(파라미터) 뭘 가지고 와야 되는지, 리턴타입 결과 출력이 어떤게 필요한지
	
	
	
	
	public void  insertMember(String id, String password,String name) throws SQLException {
		 Connection conn = connect();
		 
		 String query ="INSERT INTO member VALUES(?,?,?)";
		 PreparedStatement ps = conn.prepareStatement(query);
		 
		 ps.setString(1, id);
		 ps.setString(2, password);
		 ps.setString(3, name);
		 
		 ps.executeUpdate();
		 
		 close(ps, conn);
		
		
	}
	
	public boolean login(String id,String password) throws SQLException {
		boolean check= false;
		Connection conn = connect();
		
		String query = "SELECT * FROM member WHERE id = ? AND password=? ";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			check=true ;
		}
		
		close(rs, ps, conn);
		return check;
	}
	
	public String memberName(String id,String password) throws SQLException {
		Connection conn = connect();
		
		String query = "SELECT * FROM member WHERE id = ? AND password=? ";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		String name=null;
		
		if(rs.next()) {
			 name = rs.getString("name");
			 
		}
		close(rs,ps, conn);
		
		return name;
	}
	
	public Member searchMember(String id) throws SQLException {
		Connection conn = connect();
		
		String query = "SELECT * FROM member WHERE id = ? ";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
	
		
		ResultSet rs = ps.executeQuery();
		
		Member member = null;
		
		if(rs.next()) {
			member = new Member();
			member.setId(id);
			member.setPassword(rs.getString("password"));
			member.setName(rs.getString("name"));
			
			 
		}
		close(rs, ps, conn);
		return member;
	}
	
	public ArrayList<Member> searchAll() throws SQLException {
		Connection conn = connect();
		
		String query = "SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
		
	
		ArrayList<Member> list = new ArrayList<Member>();
		
		ResultSet rs = ps.executeQuery();
		
		
		
		while(rs.next()) {
			Member member = new Member();
			member.setId(rs.getString("id"));
			member.setPassword(rs.getString("password"));
			member.setName(rs.getString("name"));
			
			list.add(member);
			
		}
		close(rs, ps, conn);
		return list;
	}
	
	public boolean deleteMember(String id) throws SQLException {
		
		Connection conn = connect();
		
		String query = "DELETE FROM member WHERE id = ? ";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1,id);
		
		
		
		if(ps.executeUpdate() ==1) {
			close(ps, conn);
			return true;
		}else {
			close(ps, conn);
			return false;
		}
		
		
		
	} 
	
	
	
	
	
	
	
	
	
}
