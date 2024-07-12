package com.kh.array.practice3.model.controller;

import java.util.Arrays;

import com.kh.array.practice3.ApplicationAnswer;
import com.kh.array.practice3.model.BookAnswer;
import com.kh.array.practice3.model.MemberAnswer;



public class BookController {
	
     private int count =0;
	
     private MemberAnswer member = new MemberAnswer();
     
     
     
   
     
     // 내 정보 추가 
     
     public void addMember(String name,int age) {
    	 member.setName(name);
    	 member.setAge(age);
    	 
     }

	// 마이페이지 
     public MemberAnswer myPage() {
    	 
    	 return member;
     }
     
     
    // 책 대여 
     
   
     
     public String rentBook(BookAnswer[] books, int select) {
 		
    	 if (count < 2) {
    		 
    			if (member.getBookList()[count].getTitle().equals(books[0].getTitle())) {
					
					member.setCoupon(member.getCoupon() + 1);
					return "쿠폰이 적립되었습니다";
				}
    		 
				
				if (member.getAge() < books[select - 1].getAccessAge()) {
					return "연령제한입니다";
				} else if (Arrays.asList(member.getBookList()).contains(books[select - 1])) {
					return"이미 대여하신 책입니다";

				} else {
					member.getBookList()[count] = books[select - 1];
					
				
					count++;
					return "성공적으로 대여 되었습니다";
				}
			} else  return "대여한도 초과입니다";
		
				
			
       
 	}
}
