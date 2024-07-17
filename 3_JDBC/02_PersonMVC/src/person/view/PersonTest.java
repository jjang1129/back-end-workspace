package person.view;

import java.util.Scanner;

import person.controller.PersonController;
import person.model.Person;

public class PersonTest {
	Scanner sc = new Scanner(System.in);
	PersonController pc = new PersonController();

	public static void main(String[] args) {
		
		PersonTest pt = new PersonTest();
		 // 이 부분은 테스트 용도로만 ! 
	//	pt.addPerson();
	//	pt.updatePerson();
	//	pt.removePerson();
	//	pt.searchAllPerson();
	//	pt.searchPerson();  
		pt.mainMenu();
		
		
		
		
		
		
		
		}
		
		
	
       // crud 방식 
	
	// 각 Controller에 메서드들 연결하는 건 각 메서드들에서 구현

	
	public void mainMenu() {
	
		
		try {
			while(true) {
				System.out.println("원하시는 메뉴를 선택해주세요 ");
				System.out.println("1. 회원추가 ");
				System.out.println("2. 회원주소수정 ");
				System.out.println("3. 회원탈퇴 " );
				System.out.println("4. 모든회원조회 ");
				System.out.println("5. 회원검색 " );
				
				System.out.print("메뉴번호 입력 : ");
				int number = Integer.parseInt(sc.nextLine());
				switch(number) {
				case 1: try {
						addPerson();
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					}
				          break;
				case 2: updatePerson();
				         break;
				case 3: removePerson();
				         break;
					
				case 4: searchAllPerson();
				         break;
					
				case 5: searchPerson();
				break;
				
				case 6: pc.searchAllPersonAge();
					    break;
					    default : System.out.println("잘못누름");
					    break;
				}
					
				}	
				
				
			
		} catch (Exception e) {
			System.out.println("숫자만 눌러주세요");
			mainMenu();
			
		}
		
		
	
		}
	
	
	
	// person 테이블에 데이터 추가 - INSERT 
	public void addPerson() throws ClassNotFoundException {
	// System.out.println(pc.addPerson("유재석", 40, "서울시 강남구"));
	//System.out.println(pc.addPerson("강호동", 50, "서울시 용산구"));
	 System.out.print("이름 : ");
	 String name = sc.nextLine();
	 System.out.print("나이 : ");
	 int age= Integer.parseInt(sc.nextLine());
	 System.out.print("주소 : ");
	 String addr = sc.nextLine();
	System.out.println(pc.addPerson(name, age, addr));
		
	}
	
	// person 테이블에 데이터 수정 - UPDATE 
	public void updatePerson() {
		// ~~님, 정보 수정 완료 ! 
		
		System.out.print("수정할 회원 ID 입력 : ");
		int id = Integer.parseInt(sc.nextLine());
		
		
		 System.out.print("이름 : ");
		 String name = sc.nextLine();
		 System.out.print("변경할 주소 : ");
		 String addr = sc.nextLine();
		 System.out.println("변경할 나이");
		 int age =Integer.parseInt(sc.nextLine());
		 
		 
		 System.out.println(pc.updatePerson( name, addr,age, id));
		
	}
	
	// person 테이블에 데이터 삭제 - DELETE 
	public void removePerson() {
		// ~~님, 회원탈퇴 완료!
		 System.out.println("====회원 탈퇴 ====");
		 System.out.print("이름 : ");
		 String name = sc.nextLine();
		
		System.out.println(pc.removePerson(name));
	}
	// person 테이블에 있는 데이터 전체보여주기 - SELECT 
	public void searchAllPerson() {
		
		boolean check = true;
	while(check) {
		System.out.println("====조회 방식 ====");
		System.out.println("1. 가입순");
		System.out.println("2. 나이순 ");
		System.out.println("3. 이름순 ");
		System.out.println("4. 돌아가기 ");
		System.out.print("메뉴 선택 : ");
		
		int nums = Integer.parseInt(sc.nextLine());
	
		
		
		switch(nums) {
		case 1 :
		      pc.searchAllPerson();
		      break;
		case 2 :
			pc.searchAllPersonAge();
			break;
		case 3:
			pc.searchAllPersonName();
			break;
		case 4 : 
			check = false;
			break;
			default: System.out.println("잘못누르셨습니다");
		
		
		}
	}	
		
	}
	
	// person 테이블에서 데이터 한개만 가져오기 - SELECT 
	public void searchPerson() {
		
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		pc.searchPerson(name);
		
	}
	
	
}
