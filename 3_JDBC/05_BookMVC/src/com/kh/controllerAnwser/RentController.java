package com.kh.controllerAnwser;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Rent;

public class RentController {

	 private RentDAO rent = new RentDAO();
	
	//1. 책 대여 
	public boolean rentBook(int memberNo,int bookNo) {
		// 같은 책을 여러 사용자가 대여 못하게  1권이라는 가정 
		// 이미 대여된 책은 대여 불가!
		
		try {
			if(!rent.checkRentBook(bookNo)) {
			rent.rentBook(memberNo, bookNo);
		     return true;
			}
		} catch (SQLException e) {
			
			System.out.println("유효한 책 번호가 아닙니다 ");
		}
		
		return false;
		
	}
	
	// 2. 내가 대여한 책 조회
		public ArrayList<Rent> printRentBook(int memberNo) {
			// 내가 대여한 책들을 반복문을 이용하여 조회
			// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
		    try {
				return rent.printRentBook(memberNo);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;
		}
		// 3. 대여 취소 
		public boolean deleteRent(int no) {
			
			try {
				if(rent.deleteRent(no) == 1 ) {
				return true;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return false;
		}
		
}
