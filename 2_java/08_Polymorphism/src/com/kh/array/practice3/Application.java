package com.kh.array.practice3;

import java.util.Scanner;

import com.kh.array.practice1.model.Student;
import com.kh.array.practice3.member.Member;
import com.kh.array.practice3.member.controller.MemberController;
import com.kh.array.practice3.model.Book;

public class Application {
	
	 Scanner sc =new Scanner(System.in);
	 Member md = new Member();	 
	 Book[] book = new Book[4];
	 Book b = new Book();
	 int count =0;
	 int couponCount=0;
	
	
	 
	public static void main(String[] args) {
		Application app = new Application();
		
		app.mainMenu();
		
		
		   
		
 }    
	public void mainMenu() {
		
	System.out.print("이름 : ");	
	String name =sc.nextLine();
	System.out.print("나이 : ");
	int age = Integer.parseInt(sc.nextLine());
	md = new Member(name,age);
	boolean check = true;
	while(check) {
	System.out.println("====메뉴====");
	System.out.println("1. 마이페이지");
	System.out.println("2. 도서대여하기");
	System.out.println("3. 프로그램 종료하기");
	System.out.print("메뉴번호 : ");
	int num = Integer.parseInt(sc.nextLine());
	if(num == 1) {
		myPage();
		
	} else if (num == 2) {
		viewBook();
	} else if ( num == 3) {
		System.out.println("프로그램을 종료합니다. ");
		check = false;
	}
		
		
 
			
	}
	}
	
	
		
		
	
	public void myPage() {
		
		System.out.println(md);
		
	}
	
	
	
	
	public void viewBook() {
		book[0] = new Book("밥을 지어요", true, 0);
		book[1] = new Book("오늘은 덮밥", false, 0);
		book[2] = new Book("원피스 108", false, 15);
		book[3] = new Book("귀멸의 칼날", false, 19);
		for (int i = 0; i < book.length; i++) {
			System.out.println((i+1)+"번 도서" +book[i]);
		}
         System.out.print("도서 번호를 선택해주세요 : ");
		int number = Integer.parseInt(sc.nextLine());
		
		Book[] bookList = md.getBookList();
		
		if (count < 2) {
			bookList[count] = book[number - 1];			
			count++;
			if(bookList[0] == book[0] || bookList[1]==book[0]) {
				md.setCoupon(1);
			}
			
		} else {
			System.out.println("허용 가능한 대여 수를 초과하였습니다.");
		}
		if (bookList[0] != null && bookList[1] != null) {
			if (bookList[0].getTitle().equals(bookList[1].getTitle())) {
				System.out.println("이미 대여하신 책입니다");
				bookList[1] = null;
				count--;
			}
		}
		if (bookList[0] != null && bookList[0].getAccessAge() > md.getAge()) {
			System.out.println(bookList[0].getAccessAge() + "세 이상 대여가능한 책입니다");
			bookList[0] = null;
			count--;
		}
		if (bookList[1] != null && bookList[1].getAccessAge() > md.getAge()) {
			System.out.println(bookList[1].getAccessAge() + "세 이상 대여가능한 책입니다");
			bookList[1] = null;
			count--;
		}
		
		

		 //    if( count )
		    
		    	 
		    	 
		    	 
		   
		    	
		     
		    
		        
		     //	 System.out.println("이미 대여하신 책입니다");
		     
		    	 
		  }
		     
		     
		  
		   
	}   
	
	
	
