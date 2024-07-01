package com.kh.condition;

import java.util.Scanner;

public class A_If {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * if 문 
	 * 
	 * if(조건식) {
	 *  조건식이 참(true)일 때 실행 
	 * }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용 
	 * 
	 * */
    public void method1() {
    	
     //입력받은 성적이 60점 이상이면 "합격입니다"를 출력 
    // 한줄만 들어갈경우 중괄호 생략 가능 
    	System.out.print("성적을 입력하세요 :");
    	int score = sc.nextInt();
    	if(score >=60) {
    		System.out.println("합격입니다");
    	}else {
    		System.out.println("불합격입니다");
    	}
    	// 삼항연산자
    	String result = score >= 60? "합격입니다" : "불합격입니다";
    	System.out.println(result);
    	
    }
	/*
	 * if-else 문
	 * 
	 * if(조건식) {
	 * 조긴식이 참(true)일때만 실행 
	 * } else {
	 * 조건식이 거짓(false)  일떄 실행 
	 * }
	 * */
    
    public void method2() {
    	
        //입력받은 성적이 60점 이상이면 "합격입니다"를 출력 
       // 한줄만 들어갈경우 중괄호 생략 가능 
       	System.out.print("성적을 입력하세요 :");
       	int score = sc.nextInt();
       	if(score >=60) {
       		System.out.println("합격입니다");
       	}else {
       		System.out.println("불합격입니다");
       	}
       	
       }
    
    public void method3() {
    	// 본인의 이름을 입력했을때 본인이면 "본인이다", 아니면 "본인이 아니다"를 출력 
    	// 문자열 비교할때 .equls(문자열) 주소값이 원래 다른데 일치 시켜줌 
    	System.out.print("이름을 입력하세요 :");
        String name = sc.nextLine();
       
        if(name.equals("장성일")) {
        	System.out.println("본인이다");
        } else {
        	System.out.println("본인이 아니다");
        }
        
       
    	System.out.println("name의 주소값 " + System.identityHashCode(name));
    	System.out.println("이름의 주소값 " + System.identityHashCode("장성일"));
    }
    
    /*
     * if - else if - else 문
     * if(조건식1) {
     *  조건식 1이 참일떄 실행 
     *  } else if (조건식2){
     *   조건식1이 거짓이면서 조건식2가 참일때 실행 
     *  } else {
     *    조건식1,조건식2 모두 거짓일때 실행 
     *  }
     * */

	public void method4() {

		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0이다", 작으면 " 음수" 출력
		System.out.print("숫자를 입력하세요 : ");
		int number = sc.nextInt();
		if (number < 0) {
			System.out.println("음수");

		} else if (number == 0) {
			System.out.println("0이다"); // if문 중첩가능! 가급적으로는 좋은 코드는 x

		} else {
			System.out.println("양수");
		}
		// 삼항 연산자
		String result = number > 0 ? "양수" : number == 0 ? "0이다" : "음수";
		System.out.println(result);

	}
	/*
	 * 사용자에게 점수 (0~100)을 입력 받아서 점수별로 등급출력 
	 *  - 90점 이상은 A 등급
	 *  - 90점 미만 80점 이상은 B등급
	 *  - 80점미만 70 점 이상은 C등급
	 *  - 70 미만 60이상은 D등급
	 *  - 60 미만 F등급 
	 * */
	
    		public void practice1() {
    			
    			System.out.print("점수를 입력하세요 : ");
    			int score = sc.nextInt();
    			if(score > 100 || score < 0 ) {
    				System.out.println("잘못 입력하셨습니다");
    			}   			
    			else if ( score >=90) {
    				System.out.println("A등급");
    			} else if ( score >=80) {
    				System.out.println("B등급");
    			}else if ( score >=70) {
    				System.out.println("C등급");
    			}else if ( score >=60) {
    				System.out.println("D등급");
    			}else   {
    				System.out.println("F등급");
    			}
    						
    		}
    		
    		
    		/*
    		 *  세 정수를 입력했을 때 짝수만 출력 
    		 *  
    		 * */
     	     
    		public void practice2() {
    			System.out.print("첫번째 숫자 입력 : ");
    			int num1 = sc.nextInt();
    			System.out.print("두번째 숫자 입력 : ");
    			int num2 = sc.nextInt();
    			System.out.print("세번째 숫자 입력 : ");
    			int num3 = sc.nextInt();
    		
    			if(num1 % 2 == 0) System.out.println(num1);
    			if(num2 % 2 == 0) System.out.println(num2);
    			if(num3 % 2 == 0) System.out.println(num3);
	
    		}
    		
    		/*
    		 * 정수 1개를 입력했을때 음수(minus),양수(plus),0(zero), 짝even,홀odd 출력 
    		 * 
    		 * 
    		 * */
    		public void practice3() {
    			
    			System.out.print("정수를 입력하세요 : ");
    			int num = sc.nextInt();
    			System.out.println("정수 입력 : "+ num);
    			if(num == 0) {
    				System.out.println("zero");
    			} else if (num > 0) {
    				System.out.println("plus");
    			} else {
    				System.out.println("minus");
    			}
    			
    			if( num ==0) {
    				System.out.println(" ");
    			} else if (num % 2 == 0) {
    				System.out.println("even");
    			} else System.out.println("odd");
    			
    			
    		}
    		
    		
    		
    		
    		
    		
	
	public static void main(String[] args) {

		A_If a = new A_If();
	//	a.method1();
	//	a.method2();
	//	a.method3();
	//	a.method4();
	//	a.practice1();
	//	a.practice2();
		a.practice3();
	}

}
