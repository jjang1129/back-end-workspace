package com.kh.step4;

import com.kh.step4.model.Car;

public class Application {

	public static void main(String[] args) {

		Car c = new Car();
		
	/*	c.color="red";
		c.gearType="auto";
		c.door= 4;
		*/
		
	
	Car car1 = new Car("white","auto",4);
	Car car2 = new Car("black","manual");
	Car car3 = new Car("red","auto",8);
	Car car4 = new Car();
	
	 System.out.println(car1);
	 System.out.println(car2);
	 System.out.println(car3);
	 System.out.println(car4);
	
	
	 
	}
	// 오버로딩 : 한 클래스내에 동일한 이름의 메서드를 
	//          매개변수의 자료형과 개수, 순서가 다르게 작성되어야함 
	
	
	
}
