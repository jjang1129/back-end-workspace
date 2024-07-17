package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.Severinfo;

public class DBConnectionTest3 {
	
	
	

	public static void main(String[] args) {
		
	
		try {
			// 1. 드라이버 로딩 
			Class.forName(Severinfo.DRIVER_NAME);
			// 2. 디비 연결
			Connection conn = DriverManager.getConnection(Severinfo.URL,Severinfo.USER,Severinfo.PASSWORD);
		
			
			String query = "UPDATE employee SET emp_name=? WHERE emp_id = ? ";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, "장성일");
			ps.setInt(2, 900);
			System.out.println(ps.executeUpdate()+"명 수정 완료");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		// 3. PreparedStatement - 쿼리 : UPDATE (emp_id 선택해서 emp_name변경 
		
		//4. 쿼리문 실행 

	}

}
