package com.kh.variable;

public class A_Variable {
	
	/*
	 *  변수 (Variable) : 값을 저장하는 "공간"
	 * */

	public static void main(String[] args) {
		
		// 실행할 메서드가 있는 클래스를 생성(new)
		A_Variable variable = new A_Variable();
		// 생성한 클래스로 매서드 실행(호출)
//		variable.printValue();
//		variable.variableTest();
		variable.constant();
	}

	 public void printValue() {
		 // 원의 둘레와 원의 넓이를 출력하시오.
		 // 윈의 둘레는 반지름 X 2 X 3.141592..
		 // 원의 넓이는 반지름 X 반지름 X 3.141592 ... 
		 
		 // 변수를 사용하지 않고 하면 일일이 값을 바꾸고 계산해야 한다 
		 System.out.println(10*2*3.141592);
		 System.out.println(10*10*3.141592);
		 
		 System.out.println("--------------");
		 
		 // 변수를 사용하면 지정한 값만 바꾸면 된다
		 int r = 30;
		 double pi = 3.141592;
				 
		 System.out.println(r*2*pi);
		 System.out.println(r*r*pi); // syso + Ctrl space + enter 
			 
	 } 
		
	 public void variableTest() {
		 /*
		  * * 변수의 선언
		  * 
		  *  자료형 변수명 ; 공간을 만든다 
		  *  - 자료형 : 어떤 값을 저장할지, 어떤 크기의 메모리를 할당 받을지에 대한 정보
		  *  - 변수명 : 변수의 이름으로 값을 읽고, 쓰고 , 지우는 작업을 할 때 사용 
		  *  
		  *  * 변수의 초기화 
		  *  
		  *    변수명 = 값;
		  *    - 변수에 처음으로 값을 저장하는 행위 
		  *    - '='는 오른쪽 값을 왼쪽 변수에 대입(저장)하는 연산자
		  *  
		  * */
		 
		 // *기본 자료형 (Primitive type) 소문자로 시작함 : 실제 값을 저장
		 // 스택 메모리에 생성된 공간에 실제 변수값이 저장 
		 // 1. 논리형 : 1byte = 8bit
		 boolean isTrue; //  변수 선언 
		 isTrue = true ; // 변수 초기화
		 
		 boolean isFalse = false; // 변수 선언과 함께 초기화 ! 
		 
		 // 2. 문자형  : 2byte = 16bit
		 char ch = 'a';
//		 ch = 'ab';  에러 발생! -- > 주석 단축기 : 컨트롤 슬래시 
		 
		 // 3. 정수형
		 byte bNum = 1; // 크기가 1byte 값만 들어올 수 있다  1byte = (8bit ,bit는 가장최소단위) (-128~127) 256=2^8
//		 bNum = 128; 에러 발생 ! - > 오버플로우 (Overflow)
		 short sNum = 128; // 2byte ( = 16 bit) 
		 int iNum = 922337283; // 4byte ( = 32bit) 기본으로 씀 
		 long lNum = 922337283458L; // 8byte ( = 64bit) 숫자 뒤에 L(l)을 입력해야 사용 가능 
		 
		 System.out.println(lNum);
		 
		 // 4. 실수형 
		 float fNum = 1.2F; // 4byte - 숫자 뒤에 F(f) 입력! 
		 double dNum= 1.2; // 8byte (기본으로 쓰임)
		 System.out.println(fNum);
		 
		 // *참조 자료형 (기본형을 제외한 나머지 자료형들은 클래스, 클래스가 자료형 형태로 온다)) : 4byte : 주소 값을 저장
		 // 실제 데이터값은 힙 메모리에 저장하고 ,
		 // 스택 메모리의 변수 공간에는 실제 변수값이 저장된 힙 메모리의 위치값을 저장 
		 String name ="장영태"; // 반드시 여러 글자가 오면 ""
		 String name2 = new String("장영태");
		 System.out.println(name2);
		 
		 // 변수의 네이밍 규칙 
		 // 1. 대소문자 구분한다.
		 int number;
		 int NUMBER ;
		 int Number ;
//		 String number; 자료형이 달라도 변수명이 같으면 에러 발생!
		 
		 // 2. 숫자로 시작하면 안 된다.
//		 int 1age; 오류 발생 
		 int a2g3e4; // 숫자가 섞이는건 OK 
		 
		 // 3. 특수문자는 _랑 $만 사용 가능하다 .
		 int _age;
		 int age$;
//		 int %age; 오류 발생
//		 int age@; 오류 발생 
		 
		 // 4. 예약어 (Reserved word)를 사용하면 안 된다. 
//		 int public;  오류
//		 int void;   
//		 int int;  
		 int class2 ; 
		 
		 // 5. (권장사항) 낙타표기법(카멜케이스)
		 // 첫글자는 항상 소문자, 여러 단어가오면 첫 글자를 대문자로 ex) maxNumber 
		int maxnumber;  // 오류는 안나지만 권장사항임!
		int max_number; // 자바에서는 이렇게 잘안함 파이썬 O (스네이크 기법)
		int maxNumber ; // 자바에서 이렇게 
	 }
	 
	 
	 public void constant() {
		 /*
		  *  상수 
		  *  
		  *  final 자료형 변수명 ;
		  *  
		  *  - 변하지 않는 값으로 특정 변수의 값이 변경되는 걸 원하지 않을 때 사용 
		  *  - 초기화 이후에는 값을 변경할 수 없다.
		  *  - 상수의 네이밍 규칙은 모두 대문자로 표기, 여러 단어가 오면 _로 구분!!
		  * */
		 int age = 20;
		 age = 25;
		 System.out.println(age);
		 
		 final int MAX_AGE = 30;
//		 AGE = 35; 에러 발생 
		
		 System.out.println(MAX_AGE);
	 }
	   
	 
}
