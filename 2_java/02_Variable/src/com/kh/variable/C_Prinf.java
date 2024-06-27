package com.kh.variable;

public class C_Prinf {

	public static void main(String[] args) {
		// System.out.print (출력값) ; -- 출력만 함 줄바꿈 X  \n을 추가하면 줄바꿈 발생 
		// System.out.println (출력값) ; -- 출력하고 줄바꿈 O 
		System.out.print("hello\n");
		System.out.println("hello"); 
		
		System.out.println("-----------------------");
		
		// System.out.printf("출력하고자 하는 형식 (포맷)","출력하고자하는값","값","값",....);
		// 출력하고자 하는 값들이 제시한 형식에 맞춰서 출력만 진행
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10% 20% 
		
		System.out.print(iNum1+"% ");
		System.out.print(iNum2+"%\n");
		
		System.out.println(iNum1+"% " + iNum2+"%");
		/*
		 *  포맷에 쓰이는 키워드 
		 *  %d : 정수 
		 *  %f : 실수  무조건 소수점 6자리까지 보여준다 
		 *  %c : 문자
		 *  %s : 문자열(문자도 가능)   %C,%S = 출력도 대문자로 출력 
		 *  
		 * */
		System.out.printf("%d%% %d%%", iNum1, iNum2);
		System.out.println();	 // 줄바꿈 
		System.out.println("--------------------");
		
		System.out.printf("%5d\n", iNum1); // 5칸 공간 확보 후 양수 오른쪽 정렬 
		System.out.printf("%-5d\n", iNum2); // 5칸 공간 확보 후 음수 왼쪽 정렬
		System.out.println("-----------------------------");
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		
		System.out.printf("%f\t%f\n", dNum1,dNum2); // \t = tap 만큼의 공간 ( 스페이스바 4번) 
		System.out.printf("%.3f\t%.2f\n", dNum1,dNum2); // %.nf = 소수점 n자리만큼 보여줌 ! 
		System.out.println("-----------------------------");
		
		
		char ch ='a';
		String str ="Hello";
		
		// a      Hello a
		System.out.printf("%c\t%s %c\n",ch,str,ch); // a hello a
		System.out.printf("%C  %S", ch, str); // A HELLO  -- > 대문자로 출력 
		
		
		
	}
     
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
