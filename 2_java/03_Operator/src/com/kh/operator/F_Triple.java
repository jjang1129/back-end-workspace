package com.kh.operator;

import java.util.Scanner;

public class F_Triple {
        
	  Scanner sc = new Scanner(System.in);
	
  /*
   * 삼항 연산자 
   * 
   * 조건식? 값1 : 값2 ;
   * 
   *  - 조건식에는 주로 비교 , 논리 연사자가 사용된다.
   *  - 조건식의 결과가 true이면 값1을 반환한다.
   *  - 조건식의 결과가 false 이면 값2를 반환한다.
   * */
  
	  
	public static void main(String[] args) {
		
		F_Triple f = new F_Triple ();
	//	f.method1();
    // 1번    f.practice1();
	// 2번	 f.practice2();
		    f.practice3();
	}

	
	public void method1() {
		// 입력받은 정수가 양수인지 음수인지 판단 
		System.out.print("정수 값 >> ");
		int number =sc.nextInt();
		
		String result = number > 0 ? "양수" : "음수" ;
		result =  number == 0 ? "0이다" : number > 0 ? "양수" : "음수" ;
		System.out.println(result);
		// 조건식만들때 자료형은 출력값의 자료형을 쓴다 
		// 0도 포함 
	}
	
	/*
	 *  실습문제 1
	 *  사용자한테 두 개의 정수 값을 입력 받아서 두 정수의 곱셈 결과 100보다 크거나 같은 경우 
	 *  "결과가 100이상입니다 " 아닌 경우 "결과가 100보다 작습니다" 출력 
	 * 
	 * */
	 public void practice1() {
		 System.out.print("첫 번째 정수 >");
		 int num1 = sc.nextInt();
		 System.out.print("두 번째 정수 >");
		 int num2 = sc.nextInt();
		 String check = (num1 * num2) >= 100 ? "결과가 100이상입니다":"결과가 100보다 작습니다";
		 System.out.println(check);
		 
		 
	 }
	
	/*
	 *  실습문제 2
	 *  사용자한테 문자를 하나 입력받아서 대문자면
	 *  "알파벳 대문자이다." 아니면 " 알파벳 대문자가 아니다" 출력 
	 * */
	
	 public void practice2() {
		 System.out.print("문자 입력 > ");
		 char text = sc.nextLine().charAt(0);
		 String check = (65 <= text && text <=90) ? "알파벳 대문자이다." : (97 <= text && text <=122) ? "알파벳 대문자가 아니다" : "알파벳이 아닙니다.";
		 System.out.println(check);
		 
	 }
	/*
	 * 실습문제 3
	 * 두 정수를 입력 받고 + 또는 -를 입력 받아서 계싼을 출력 
	 * 단, +또는 -이외의 문자를 입력하는 경우 "잘못입력했습니다" 출력 
	 * 
	 * 예시 ) 
	 * 첫번째 수 > 3
	 * 두번째 수 > 4
	 * 연산자 입력 (+또는 -) 
	 * 3+4=7
	 * 
	 * 연산자 입력 (+또는 -) > -
	 * 3-4 = -1
	 * 
	 * 연산자 입력 (*)
	 * 
	 * "잘못입력했습니다 
	 * 
	 * 
	 * */
	 
    public void practice3() {
		 // 정수 입력명령문 + 정수 받는문 
    	System.out.print("첫번째 수 > ");
    	int num1 =sc.nextInt();
    	System.out.print("두번째 수 > ");
    	int num2 =sc.nextInt();
    	sc.nextLine();
    	 // 연산자 입력명령문 + 연산자 받는문 
    	System.out.print("연산자 입력( + 또는 -) ");
    	char a = sc.nextLine().charAt(0);
    	 // 입력된 연산자 계산문 
    	
    	
    	 String answer = a == '+'? num1 +"+"+num2+ "="+(num1+num2) 
    	    		: a == '-'? num1+"-"+num2+"="+(num1-num2) : "잘못 입력했습니다";
       System.out.println(answer);
    	// 지정된 연산자가 아닐경우 " 잘못입력!"
      
       if( a == '+' || a =='-') {
    	   
       
    System.out.printf("%d %s %d = %d",num1,a,num2, a=='+' ? (num1+num2) : (num1-num2));	
       } else {
    	   System.out.println("잘못 입력했습니다");
       }  
       
       // 또 다른 방법2
       
       
       

 
  // 	 String answer1 = a == '+'? String.format("%d+%d =%d", num1,num2,(num1+num2))
 //	    		: a == '-'? String.format("%d-%d =%d", num1,num2,(num1-num2)) : "잘못 입력했습니다";
       
  //     System.out.println(answer1);
       
       
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}
