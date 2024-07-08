package com.kh.polymorphism;

import java.util.Scanner;

import com.kh.polymorphism.controller.EmployeeController;
import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.child.Manager;
import com.kh.polymorphism.model.child.Secretary;
import com.kh.polymorphism.model.parent.Employee;

/*
 * 다형성 (Polymorphism)
 * - 하나의 객체 변수가 여러가지 모양과 모습을 가지는 능력 
 * - 부모 타입으로 자식 객체를 생성하는 것 
 * 
 * */



public class Application {
      
	
	
	public static void main(String[] args) {
		
       Employee e1 = new Employee("우현성",10000);
       Engineer e2 = new Engineer("이동엽",5000,"자바",200);
       Manager m1 = new Manager ("윤유진",7000,"개발팀");
       Secretary s1 = new Secretary("송준호",6000,"우현성");
       
       System.out.println(e1);
       System.out.println(e2);
       System.out.println(m1);
       System.out.println(s1);
		
      Employee e3 = new Engineer("이동엽",5000,"자바",200);
       Employee m2 = new Manager ("윤유진",7000,"개발팀");
      Employee s2 = new Secretary("송준호",6000,"우현성");
      
      // 다형성 + 객체 배열 
      
      Employee [] empArr = {e1,e3,m2,s2};
      System.out.println(empArr[1]);
      for( Employee employee : empArr) {
    	  System.out.println(employee);
      }
      
      EmployeeController ec = new EmployeeController();
      Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		ec.findEmployeeByName(name,  empArr);
		System.out.println("찾는 사람의 연봉은? : ");
		ec.getAnnualSalaray(ec.findEmployeeByName(name, empArr));
	   
		
		
		System.out.print("연봉의 합계 : ");
		ec.getTotalSalary(empArr);
	}

}
