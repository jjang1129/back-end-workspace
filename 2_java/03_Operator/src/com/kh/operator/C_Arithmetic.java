package com.kh.operator;

public class C_Arithmetic {
	
	/*
	 *  산술 연산자 
	 *   + : 더하기
	 *   - : 빼기 
	 *   * : 곱하기
	 *   / : 나누기
	 *   % : 나머지 
	 * */

	public static void main(String[] args) {

		C_Arithmetic c = new C_Arithmetic();
		c.method1();
		c.method2();
	}
	
	public void method1() {

		int num1 = 10;
		int num2 = 3;

		System.out.println("+ : " + (num1 + num2));
		System.out.println("- : " + (num1 - num2));
		System.out.println("* : " + (num1 * num2));
		System.out.println("/ : " + (num1 / num2));
		System.out.println("% : " + (num1 % num2));

	}
	// 코드 정렬 깔끔하게 하고 싶다면!
	// 해당 영역 잡고 ctrl + shift + f 
	// 그냥 하면 주석까지 정렬을 해서 망가져요 
	
	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b; // 16 a= 6
		int d = c / a; // 2
		int e = c % a; // 4
		int f = e++; // f= 4 e= 5
		int g = (--b) + (d--); // b=9 , d= 2 g= 11 , d=1
		int h = c-- * b; // h = 144 c= 15
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h);

		// 6+ 9/ 3 * 10 % 150 = 36 ?
	}
	
	
	

}
