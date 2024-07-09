package com.kh.array.practice3;

import java.util.Scanner;

import com.kh.array.practice1.model.Student;
import com.kh.array.practice3.member.Member;
import com.kh.array.practice3.member.controller.MemberController;
import com.kh.array.practice3.model.Book;

public class Application {
	
	 Scanner sc =new Scanner(System.in);
	 Member md = new Member();
	 private Book[] bookList = new Book[2];
	 
	 Book[] book = new Book[4];
	 
	
	
	 
	public static void main(String[] args) {
		Application app = new Application();
		
		app.mainMenu();
		
		
		   
		
 }    
	public void mainMenu() {
		
	System.out.print("이름 : ");	
	String name =sc.nextLine();
	System.out.print("나이 : ");
	int age = Integer.parseInt(sc.nextLine());
	md = new Member(name,age,0,bookList);
	boolean check = true;
	while(check) {
	System.out.println("====메뉴====");
	System.out.println("1. 마이페이지");
	System.out.println("2. 도서대여하기");
	System.out.println("3. 프로그램 종료하기");
	System.out.println("메뉴번호 : ");
	int num = Integer.parseInt(sc.nextLine());
	if(num == 1) {
		myPage();
		
	} else if (num == 2) {
		viewBook();
		int select = Integer.parseInt(sc.nextLine());
		int i=0;
		int count = 0;
		System.out.println(book[select-1]);
		bookList[0] = book[select-1];
		if(bookList[0] != null && bookList[1] == null) {
			bookList[1] = book[select-1];
		}
		myPage();
		}
	} 
			
	}
	
	
	
		
		
	
	public void myPage() {
		
		System.out.println(md);
		
	}
	
	
	
	
	
	public void viewBook() {
		   book[0] = new Book("밥을 지어요",true,0);
		   book[1] = new Book("오늘은 덮밥",false,0);
		   book[2] = new Book("원피스 108",false,15);
		   book[3] = new Book("귀멸의 칼날",false,19);
		
		
		   for(int i= 0; i<book.length; i++) {
			   System.out.println(book[i]);
		   }
		   
	}
	
	
}