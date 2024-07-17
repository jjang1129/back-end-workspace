package person.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import config.Serverinfo;
import person.model.Person;

  

public class PersonController {
	// 리턴 타입이나 매개변수(파라미터) 자유롭게 변경 가능!
	// 메서드 추가 가능 ! < -- 추천 
	/*
	 *  1. 드라이버 로딩
	 *  2. DB 연결
	 *  3. preparedStatement- 쿼리
	 *  4. 쿼리 실행 
	 * 
	 * */
	// 고정적인반복 --DB 연결, 자원반납 -> 공통적인 메서드 메서드마다 호출해서 사용!
	
	// 변동적인 반복 -- 비즈니스 로직 DAO (Database Access Object)

	 public PersonController() {
		   try {
			Class.forName(Serverinfo.DRIVER_NAME);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	    }
	 
	 public Connection getConnect() throws SQLException {
		 
		 return	DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
		
		 
	 }

	
	   
	
	
		// person 테이블에 데이터 추가 - INSERT 
	
		public String addPerson(String name,int age,String addr) throws ClassNotFoundException {
			try {
				
				Connection conn= getConnect();
				String query ="INSERT INTO person (name,age,addr) VALUES(?,?,?)"; 
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, name );
				ps.setInt(2, age);
				ps.setString(3, addr);
				ps.executeUpdate();
				
				String result =name+"님 회원가입이 완료되었습니다. ";
				
				conn.close();
				ps.close();
				
				return result;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return "회원가입 실패 ";
		}
		
		// person 테이블에 데이터 수정 - UPDATE 
		public String updatePerson(String name,String addr,int age,int id) {
			try {
				
				
				Connection conn= getConnect();
				String query ="UPDATE person SET addr=?,age=?,name=? WHERE id=?";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, addr);
                ps.setInt(2, age);
                ps.setString(3, name);
                ps.setInt(4, id);
                
                
             
				
				return  id+"번 회원님 정보 변경 완료! ";
				
              
			} catch (SQLException e) {
				
				return "주소 수정 실패 ";
			}
			
		}
		
			
			
			
			
			
			
			
			
		
		
		// person 테이블에 데이터 삭제 - DELETE 
		public String removePerson(String name) {
			try {
				
				Connection conn= getConnect();
				String query ="DELETE FROM person WHERE name = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, name);
                		              
                ps.executeUpdate();
                
            return   name+"님 회원탈퇴 완료되었습니다";
              
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			return null;
			
			
		}
			
		
		
			
		
		// person 테이블에 있는 데이터 전체보여주기 - SELECT 
		public void searchAllPerson() {
			try {
				Class.forName(Serverinfo.DRIVER_NAME);
				Connection conn = DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
				
				String query ="SELECT * FROM person";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
				int id =rs.getInt("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				String addr=rs.getString("addr");
					
				System.out.println("id :"+id+" 이름 :" + name + " 나이 : " +age +" 주소 : "+addr );
				}
				
				rs.close();
				ps.close();
				conn.close();
				
			} catch (ClassNotFoundException | SQLException e) {
				
				
			}
			
		
			
		}
		
		// person 테이블에서 데이터 한개만 가져오기 - SELECT 
		public void searchPerson(String name) {
			try {
				Class.forName(Serverinfo.DRIVER_NAME);
				Connection conn = DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
				
				String query ="SELECT * FROM person WHERE name =?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, name);
				
				
				
				ResultSet rs = ps.executeQuery();
			
				if(rs.next()) {
					int id= rs.getInt("id");
					int age=rs.getInt("age");
					String addr=rs.getString("addr");
					
					
		    	 System.out.println("id :"+id+" 이름 :" + name + " 나이 : " +age +" 주소 : "+addr );
		    	 
				}	
				closeAll(ps, conn);
				rs.close();
           
						
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
			
		}
		
		public void searchAllPersonAge() {
			try {
				Class.forName(Serverinfo.DRIVER_NAME);
				Connection conn = DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
				
				String query ="SELECT * FROM person ORDER BY age DESC";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int id =rs.getInt("id");
					String name=rs.getString("name");
					int age=rs.getInt("age");
					String addr=rs.getString("addr");
					
					System.out.println("id :"+id+" 이름 :" + name + " 나이 : " +age +" 주소 : "+addr );
				}
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
		
			
		}
		public void searchAllPersonName() {
			try {
				Class.forName(Serverinfo.DRIVER_NAME);
				Connection conn = DriverManager.getConnection(Serverinfo.URL,Serverinfo.USER,Serverinfo.PASSWORD);
				
				String query ="SELECT * FROM person ORDER BY name ASC";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int id =rs.getInt("id");
					String name=rs.getString("name");
					int age=rs.getInt("age");
					String addr=rs.getString("addr");
					
					System.out.println("id :"+id+" 이름 :" + name + " 나이 : " +age +" 주소 : "+addr );
				}
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
				
			}
			
		
			
		}
		// 자원반납 메서드
		public void closeAll(PreparedStatement ps, Connection conn) {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
		

}
