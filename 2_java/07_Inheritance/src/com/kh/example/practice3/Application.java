package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;


public class Application {
	
	
	
	

	        Scanner sc = new Scanner(System.in);
	        Employee viewEmployee = new Employee();
	       
	        EmployeeController employeeController = new EmployeeController();
		public static void main(String[] args) {
			
			Application a= new Application();
			boolean check = true;
		while(check) {
		 int select =	a.employeeMenu();
		 switch(select) {
		 case 1 : a.insertEmp();
			 break;
		 case 2 : a. updateEmp();
			 break;
		 case 3 : 
			 a.prinEmp();
			 break;
		 case 9 : 
			 System.out.println("프로그램을 종료합니다. ");
			 check = false;
			 break;
			 default: 
				 System.out.println("잘못 입력하셨습니다. 다시 입력해주세요~");
		 }
		}	
			
		}
		
		public int employeeMenu() {
			// 메뉴 출력
			
				System.out.println("1.사원 정보 추가");
				System.out.println("2.사원 정보 수정");
				System.out.println("3.사원 정보 출력");
				System.out.println("9. 프로그램 종료 ");
				System.out.print("메뉴 번호를 눌러주세요 : ");
				int number = sc.nextInt();
			
			return number;
		}
		public void insertEmp () {
			
			// 사원 추가
			System.out.print("사원 번호 : ");
		//	int empNo =sc.nextInt();
		//	sc.nextLine();
			viewEmployee.setEmpNo(sc.nextInt());
			sc.nextLine();
			System.out.print("사원 이름 : ");
		//	String name = sc.nextLine();
			viewEmployee.setName(sc.nextLine());
			System.out.print("사원 성별 : ");
		//	char gender = sc.nextLine().charAt(0);
			viewEmployee.setGender(sc.nextLine().charAt(0));
			System.out.print("전화번호  : ");
		//	String phone = sc.nextLine();
			viewEmployee.setPhone(sc.nextLine());
			employeeController.add(viewEmployee.getEmpNo(),
					viewEmployee.getName(),
					viewEmployee.getGender(),
					viewEmployee.getPhone());
			System.out.print("추가 정보를 입력하시겠습니까? (y/n ");
			char select = sc.nextLine().charAt(0);
			if(select == 'y') {
			System.out.print("사원 부서 : ");
			String dept = sc.nextLine();
			System.out.print("사원 연봉 : ");
			int salary = Integer.parseInt(sc.nextLine());
			System.out.print("보너스 율 : ");
			double bonus =Double.parseDouble(sc.nextLine());
			employeeController.add(viewEmployee.getEmpNo(), viewEmployee.getName(), viewEmployee.getGender(), viewEmployee.getPhone(), viewEmployee.getDept(), viewEmployee.getSalary(),viewEmployee.getBonus());
			}
		}
		
		public void updateEmp() {
			// 정보 추가
		while(true) {	
			System.out.println("어떤 정보를 수정하시겠습니까?");
			System.out.println("1. 전화번호  ");
			System.out.println("2. 사원 연봉 ");
			System.out.println("3. 보너스 율 ");
			System.out.println("9. 돌아가기 ");
			System.out.print("메뉴 번호를 누르세요 : ");
		//	int select = Integer.parseInt(sc.nextLine());
			int select = sc.nextInt();
			sc.nextLine();
			if (select == 1) {
			System.out.print("전화번호 : ");
			String phone = sc.nextLine();
			employeeController.modify(phone);
			break;
			} else if(select == 2) {
			System.out.print("사원 연봉 : ");
			int salary = sc.nextInt();
			employeeController.modify(salary);
			break;
			} else if (select == 3) {
			System.out.print("보너스 율 :  ");
			double bonus =sc.nextDouble();
			employeeController.modify(bonus);
			break;
			} else if (select == 9) {
			   break;
			} else {
				System.out.println("잘못누르셨습니다 ");
				
			}
		}
		}
		public void prinEmp() {
			// 사원 출력
			
			System.out.println(employeeController.info());
			
		}
	}
	


