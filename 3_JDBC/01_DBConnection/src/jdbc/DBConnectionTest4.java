package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import config.Severinfo;

public class DBConnectionTest4 {

	public static void main(String[] args) {
		
		try {
			
			// 쿼리문을 파일로 따로 저장해놓고 불러오는 방법 
			//1. new file로 파일 생성후 키값 = 쿼리문 양식으로 작성 
			//2. preoperies 객체 생성 
			//3. 객체명.load(new FileInputStream("파일의 경로 ")
			//4. String query = 객체명.getProperty("키값") 으로 담아놓고 사용 
			//5.  결국 query라는 변수명이 아까 저장한 파일의 쿼리문을 담고있음 
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			// 1. 드라이버 로딩 
			Class.forName(Severinfo.DRIVER_NAME);
			// 2. DB연결 
			Connection conn =DriverManager.getConnection(Severinfo.URL,Severinfo.USER,Severinfo.PASSWORD);
			// 3. query문 작성 
			String query= p.getProperty("delete");
			PreparedStatement ps =conn.prepareStatement(query);
			
			ps.setInt(1, 900);
			
			System.out.println(ps.executeUpdate()+"명 삭제 완료!"); // 추가 , 수정 , 삭제는 executeUpdate  SELECT만 exeQuery 
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}

	}

}
