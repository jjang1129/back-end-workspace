package com.kh.array.practice3;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice3.model.BookAnswer;
import com.kh.array.practice3.model.MemberAnswer;
import com.kh.array.practice3.model.controller.BookController;

public class ApplicationAnswer {

	BookController bc = new BookController();
	MemberAnswer member = new MemberAnswer();
	Scanner sc = new Scanner(System.in);
	BookAnswer[] books = { new BookAnswer("밥을 지어요", true, 0), new BookAnswer("오늘은 아무래도 덮밥", false, 0),
			new BookAnswer("원피스 108", true, 15), new BookAnswer("귀멸의 칼날 23", true, 19) };
	int count = 0;

	public static void main(String[] args) {

		ApplicationAnswer app = new ApplicationAnswer();
		app.menu();

	}

	public void menu() {

		System.out.print("이름 : ");
		String name = sc.nextLine();
		member.setName(name);
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		member.setAge(age);
		boolean check = true;
		while (check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이 페이지 ");
			System.out.println("2. 도서 대여하기 ");
			System.out.println("3. 프로그램 종료 ");
			System.out.print("메뉴 번호 : ");
			int number = Integer.parseInt(sc.nextLine());
			

			if (number == 1) {
				System.out.println(member);
			} else if (number == 2) {
				for (int i = 0; i < books.length; i++) {
					System.out.println((i + 1) + "번 도서 : " + books[i]);
				}
				System.out.println("대여할 도서 번호 : ");
				int select = Integer.parseInt(sc.nextLine());
				System.out.println(bc.rentBook(books, select));
				
			} else if (number == 3) {
				System.out.println("프로그램을 종료합니다");
				check = false;
				break;
			} 

		}
	}

}
