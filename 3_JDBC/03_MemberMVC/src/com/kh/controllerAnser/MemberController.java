package com.kh.controllerAnser;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.ch.modelAnswer.Member;

import config.Serverinfo;

public class MemberController {
	Properties p= new Properties();
	
	//싱글톤 패턴(Singleton pattern)
	// - 디자인 패턴 중 하나로 클래스가 최대 한 번만 객체 생성되도록 하는 패턴
	
	// 1. 원래 기본적으로 생성자는 public이지만 싱글톤 패턴에서는 private으로 한다 
	// 생성자에서는 throw 안하고 try catch 잡는다 
	
	// 드라이버 로딩 메서드 
	private MemberController() {
		
		
		try {
			
			// 작성한 쿼리문 불러오기
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			
			// (1) 드라이버 로딩 
			Class.forName(Serverinfo.DRIVER_NAME);
			
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	//2. 유일한 객체를 담을 static 변수 
	private static MemberController instance;
	
	//3. 객체를 반환하는 static 메서드 
	
	public static MemberController getInstance() {
		if(instance == null) instance =new MemberController();
		return instance;
	}
	
	
	//커넥션 메서드 
	public Connection connect() throws SQLException {
	return DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
		
		
	}
	
	// 자원 반납 묶음 메서드1 
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	// 자원 반납 묶음 메서드 2
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps,conn);
	}
	// 기존에 아이디가 있는지 체크하는 메서드 
	public boolean idCheck(String id) throws SQLException {
		
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("idCheck"));
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		String checkId = null;
		if(rs.next()) checkId=rs.getString("id");
		close(rs,ps,conn);
		
		if(checkId!=null) return true;
		return false;
		
		
	}
	
	
	public boolean signUp(Member m) throws SQLException {
		// 회원가입 기능 구현! 
		
	
		
		// -> 아이디가 기존에 있는지 체크 여부!
	if(!idCheck(m.getId())) {	
		// -> member 테이블에 데이터 추가! 
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("signUp"));
		ps.setString(1, m.getId());
		ps.setString(2, m.getPassword());
		ps.setString(3, m.getName());
		
		ps.executeUpdate();
		close(ps,conn);
		return true;
	}
		
          return false;
	}
	
	public String login(String id, String password) throws SQLException {

		// 로그인 기능 구현! 
		
		// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!
		Connection conn= connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("login"));
		ps.setString(1,id );
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		String name=null;	
		
		if(rs.next()) name=rs.getString("name");
		close(rs,ps,conn);
		return name;
		
	}
	
	public boolean changePassword(String id,String oldpw,String newpw) throws SQLException {

		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경
		
		
		
		if(login(id,oldpw) != null) {
			Connection conn= connect();
			PreparedStatement ps =conn.prepareStatement(p.getProperty("changePassword"));
			ps.setString(1, newpw);
			ps.setString(2, id);
			ps.executeUpdate();
			close(ps, conn);
			return true;
		}
		
		
		
          return false;
	}
	
	public void changeName(String id,String newName) throws SQLException {

		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("changeName"));
		ps.setString(1, newName);
		ps.setString(2, id);
		ps.executeUpdate();
		
		close(ps, conn);
		
		
		
	}
	
}









