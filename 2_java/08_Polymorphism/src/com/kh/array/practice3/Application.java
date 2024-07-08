package com.kh.array.practice3;

import java.util.Scanner;

import com.kh.array.practice1.model.Student;
import com.kh.array.practice3.member.Member;
import com.kh.array.practice3.member.controller.MemberController;
import com.kh.array.practice3.model.Book;

public class Application {

	public static void main(String[] args) {
		MemberController mc = new MemberController();
		Member member = new Member();
		Scanner sc= new Scanner(System.in);
		 System.out.print("이름 : ");
		 String name = sc.nextLine();
		 System.out.print("나이 : ");
		 int age =Integer.parseInt(sc.nextLine());
		 Book [] arr = new Book [5];
		 arr[0] = 
		 
		 System.out.println("======메뉴=====");
		 System.out.println("1.마이 페이지 ");
		 System.out.println("2.도서 대여하기 ");
		 System.out.println("3.프로그램 종료하기");
		 System.out.println("메뉴 번호 : ");
		 int number =Integer.parseInt(sc.nextLine());
		 mc.info();

	}

}
