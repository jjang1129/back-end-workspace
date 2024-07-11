package com.kh.array.practice3;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice3.model.BookAnswer;
import com.kh.array.practice3.model.MemberAnswer;

public class ApplicationAnswer {
	
	MemberAnswer member = new MemberAnswer();
	Scanner sc = new Scanner(System.in);
	BookAnswer[] books = {new BookAnswer("밥을 지어요",true,0),new BookAnswer("오늘은 아무래도 덮밥",false,0),
			new BookAnswer("원피스 108",true,15),new BookAnswer("귀멸의 칼날 23",true,19)
	};
	int count = 0;

	public static void main(String[] args) {
		
		ApplicationAnswer app= new ApplicationAnswer();
		app.menu();
			

	}

	public void menu() {
			
		System.out.print("이름 : ");
		String name = sc.nextLine();
		member.setName(name);
		System.out.print("나이 : ");	
		int age =Integer.parseInt(sc.nextLine());
		member.setAge(age);
		
		while(true) {
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 마이 페이지 ");
		System.out.println("2. 도서 대여하기 ");
		System.out.println("3. 프로그램 종료 ");
		System.out.print("메뉴 번호 : ");
		int number = Integer.parseInt(sc.nextLine());	
		
		if(number == 1) {
			System.out.println(member);			
		} else if(number == 2 && count < 2) {
		  for(int i = 0; i<books.length; i++) {
			  System.out.println((i+1) +"번 도서 : " + books[i]);
		  }
			System.out.println("대여할 도서 번호 : ");
			int select = Integer.parseInt(sc.nextLine());
			// select에 따라서 해당 책이 memberAnser-bookList에 추가 되어야함 
			// 첫 실행시 무조건 0번째 인덱스에 들어가고 0번째 인덱스가 NULL이 아니면서 
			// 1번째 인덱스가 NULL일때 1번째 인덱스에 들어가야함 0번째,1번째 모두 NULL이 아닐경우 더이상 대여 불가능. 연령제한이 걸려 있고 , 중복대여는 불가능함 
			if(member.getAge() < books[select-1].getAccessAge() ) {
			    System.out.println("연령제한입니다");
			    
			} else if (member.getBookList()[0] != null  && member.getBookList()[0].getTitle().equals(books[select-1].getTitle())){
				System.out.println("이미 대여하신 책입니다");
				
			}else {
				member.getBookList()[count] = books[select-1]; 
				System.out.println("성공적으로 대여되었습니다"); 
				if(member.getBookList()[count].getTitle().equals(books[0].getTitle())) {
					System.out.println("쿠폰이 적립되었습니다");
					member.setCoupon(1);
				}
				count++;
			} 
		} else System.out.println("대여횟수 초과입니다");
	}	
		
		
		
	}
	
	
	
	
}
