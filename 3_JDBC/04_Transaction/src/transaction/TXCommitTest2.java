package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TXCommitTest2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/member","root","qwer1234");
			
		//	conn.setAutoCommit(false);
			/*
			 * 동엽 -> 동호 : 3만원씩 이체 
			 * 동엽님의 잔액이 마이너스가 되면 이체 취소 되어야함!
			 * 
			 * */
			// 3개 필요! UPDATE 2개 SELECT 1개 
			
			// 잔액이 없으므로 이체 취소 !
			// 잔액이 있으므로 이체 성공 ! 
			
			
			
			
			
			conn.setAutoCommit(false);
			
			String query4 ="SELECT * FROM bank WHERE name=?";
			PreparedStatement ps4 = conn.prepareStatement(query4);
			ps4.setString(1, "동엽");
			
			ResultSet rs1=ps4.executeQuery();
			
			
			
			
			
			String query1 ="UPDATE bank SET balance=balance-? WHERE name=?";
			String query2 ="UPDATE bank SET balance=balance+? WHERE name=?";
			
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setInt(1, 30000);
			ps1.setString(2, "동엽");
				
			ps1.executeUpdate();
			
			
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setInt(1, 30000);
			ps2.setString(2, "동호");
			ps2.executeUpdate();
			
			
			
			
			String query3 ="SELECT * FROM bank WHERE name=?";
			PreparedStatement ps3 = conn.prepareStatement(query3);
			ps3.setString(1, "동엽");
			
			ResultSet rs=ps3.executeQuery();
			
			if(rs.next() && rs1.next()) {
				if(rs.getInt("balance") < 0 ) {					
					conn.rollback();
					System.out.println("잔액이 없으므로 이체 취소! "+ rs1.getString("name")+"님의 잔액은  " + rs1.getInt("balance")+"원입니다");
				}else {
					System.out.println("잔액이 있으므로 이체 성공! "+ rs.getString("name")+"님의 잔액은  " + rs.getInt("balance")+"원입니다");
					conn.commit();
				}
			}
			
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
