package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionTest2 {
	
	public static final String DRIVER_NAME ="com.mysql.cj.jdbc.Driver"; // 드라이버 로딩에 필요한 string을 변수로 지정
	public static final String URL= "jdbc:mysql://localhost:3306/kh"; 
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";
	

	public static void main(String[] args) {
               
	         try {
	        	 //1. 드라이버 로딩 
				Class.forName(DRIVER_NAME);
				  //2. 데이터베이스 연결 Connection 으로 담아놔야 나중에 쓰기편함 
				Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
				System.out.println("드라이버로딩,데이터베이스연결");
				//3.PreparedStatement- Insert 
			String query = "INSERT INTO employee(emp_id,emp_name,emp_no) VALUES(?,?,?)"; // 변수지정 
	       PreparedStatement ps = conn.prepareStatement(query);
	       
	       ps.setInt(1, 900); // 물음표 채우기 
	       ps.setString(2, "김미경");
	       ps.setString(3,  "111111-1111111");
	       // 4. 쿼리문 실행 
	      System.out.println( ps.executeUpdate()+"명 추가!");
				
			
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
	      
}

}
