package com.kh;

import java.time.LocalDate;
import java.util.Scanner;
import java.sql.Date;

import com.kh.controllerAnwser.BookController;
import com.kh.controllerAnwser.MemberController;
import com.kh.controllerAnwser.RentController;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.model.vo.Rent;




public class Application2 {
	// 스키마 : sample
	// 테이블 : member , book, publisher, rent
	
	//로그인 했을시 사용자 정보를 담는 객체!
	
	
     private MemberController mc = new MemberController();
	private Scanner sc = new Scanner(System.in);
	private Member member = new Member();
	private RentController rc = new RentController();
  
    BookController bc1 = new BookController();
 	
	public static void main(String[] args) {
	

		Application2 app = new Application2();
		app.mainMenu();

	}

	public void mainMenu() {
		System.out.println("===== 도서 관리 프로그램 =====");

		boolean check = true;
		while (check) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록");
			System.out.println("3. 책 삭제");
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				sellBook();
				break;
			case 4:
				registerMember();
				break;
			case 5:
				login();
				break;
			case 9:
				check = false;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	// 1. 전체 책 조회
	public void printBookAll() {
		// 반복문을 이용해서 책 리스트 출력
		for(Book book : bc1.printBookAll()) {
			String pubName = book.getPublisher().getPubName();
			System.out.println("책 번호 : " + book.getBkNo()
			                   + " / 책 제목 : "+ book.getBkTitle()
			                   +" / 저자 : " + book.getBkAuthor()
			                   +(pubName!=null? " / 출판사 : "+ book.getPublisher().getPubName() : ""));
			                        // 삼항연산자로 출판사가 NULL이 아닐때만 출력 NULL이면 비워두기 
		}
	}

	// 2. 책 등록
	public void registerBook() {
		// 책 제목, 책 저자를 사용자한테 입력 받아
		System.out.print("책 제목 : ");
		String title= sc.nextLine();
		System.out.print("책 저자 : ");
		String author =sc.nextLine();
		// 기존 제목 , 저자 있으면 등록 안되게 -> 컨트롤러 
		
		if(bc1.registerBook(title,author)) { // 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
			System.out.println("성공적으로 책을 등록했습니다");
		} else { // 실패하면 "책을 등록하는데 실패했습니다." 출력
			System.out.println("책을 등록하는데 실패했습니다.");
		}
		
		
		
		
		
	
	}

	// 3. 책 삭제
	public void sellBook() {
		// 빌려있는 책 삭제 못하게 !
		// printBookAll로 전체 책 조회를 한 후
		printBookAll();
		// 삭제할 책 번호 선택을 사용자한테 입력 받아
		System.out.print("삭제할 책 번호 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		if(bc1.sellBook(no)) {
			// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
			System.out.println("성공적으로 책을 삭제했습니다.");
		}else {
			// 실패하면 "책을 삭제하는데 실패했습니다." 출력
			System.out.println("책을 삭제하는데 실패했습니다.");
		}
		
		
	
		
	}

	// 4. 회원가입
	public void registerMember() {
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
		// 실패하면 "회원가입에 실패했습니다." 출력
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("이름 : ");
		String name=sc.nextLine();
		
		
		if(mc.registerMember(id,password,name)) {
			System.out.println("성공적으로 회원가입을 완료하였습니다.");
		} else {
			System.out.println("회원가입에 실패했습니다.");
		}
		
		
		
		
		
	}

	// 5. 로그인
	public void login() {
		// 아이디, 비밀번호를 사용자한테 입력 받아 
		System.out.print("아이디 : ");
		String id =sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		 member = mc.login(id,password);
		 if(member != null) {
			 System.out.println(member.getMemberName() +"님, 환영합니다");
			 memberMenu();
		 }else {
			 System.out.println("로그인에 실패했습니다. ");
		 }
		
		 // 로그인에 성공하면 "~~님, 환영합니다!" 출력 후 memberMenu() 호출
			
		 // 로그인에 성공하면 "~~님, 환영합니다!" 출력 후
			
		
		
		
		
	
	}

	public void memberMenu() {
		boolean check = true;
		while (check) {
			System.out.println("1. 책 대여");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원탈퇴");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				rentBook();
				break;
			case 2:
				printRentBook();
				break;
			case 3:
				deleteRent();
				break;
			case 4:
				check = false;
				break;
			case 5:
				deleteMember();
				check = false;
				break;
			}
		}
	}

	// 1. 책 대여
	public void rentBook() {
		// printBookAll 메서드 호출하여 전체 책 조회 출력 후
		printBookAll();
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		System.out.println("대여할 책 번호 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		// 이미  대여된 책은 대여 불가
		if(rc.rentBook(member.getMemberNo(),no)) {
			// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
			System.out.println("성공적으로 책을 대여했습니다.");
		} else {
			// 실패하면"책을 대여하는데 실패했습니다."
			System.out.println("책을 대여하는데 실패했습니다.");
		}
	      
	}

	// 2. 내가 대여한 책 조회
	public void printRentBook() {
		// 내가 대여한 책들을 반복문을 이용하여 조회
		
		for(Rent rent : rc.printRentBook(member.getMemberNo())) {
			LocalDate localDate = new Date(rent.getRentDate().getTime()).toLocalDate();
			// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
			System.out.println("대여 번호 : " + rent.getRentNo() +
					           " / 책 제목 : " + rent.getBook().getBkTitle() +
					            " / 책 저자 : "+ rent.getBook().getBkAuthor() +
					            " / 대여 날짜 : " + rent.getRentDate() + 
					            " / 반납 기한 : "+ localDate.plusDays(14));
		}
	
	}

	// 3. 대여 취소
	public void deleteRent() {
		// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
		printRentBook();
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		System.out.print("취소할 대여 번호 선택 : ");
		int no = Integer.parseInt(sc.nextLine());
		// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
		// 실패하면 "대여를 취소하는데 실패했습니다." 출력
		if(rc.deleteRent(no)) {
			System.out.println("성공적으로 대여를 취소했습니다.");
		}else {
			System.out.println("대여를 취소하는데 실패했습니다.");
		}
	}

	// 5. 회원탈퇴
	public void deleteMember() {
		// 대여중인 책이 있으면 탈퇴 못하게하기 
		// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
		// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
		if(mc.deleteMember(member.getMemberNo())) {
			System.out.println("회원탈퇴 하였습니다 ㅠㅠ");
		} else {
			System.out.println("회원탈퇴하는데 실패했습니다.");
		}
		
	
		
			
	
	}

}
