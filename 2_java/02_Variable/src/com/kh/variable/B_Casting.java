package com.kh.variable;

public class B_Casting {
	
	/*
	 *  형 변환 (Casting)
	 *   - 값의 타입을 다른 탑입으로 변환하는것 ( 자료형 변환) 
	 *   - boolean을 제외한 7개의 기본형은 서로 형변환이 가능하다 
	 *  
	 * */
	
	
	

	public static void main(String[] args) {
		
		B_Casting casting = new B_Casting();
//		casting.autoCasting();
		casting.casting();
       
	}
     
	/*
	 *  자동 형 변환 ( 묵시적 형 변환)
	 *  - 자동으로 형 변환이 이루어지기 때문에 따로 형 변환하지 않아도 된다. 
	 *  
	 * */
	public void autoCasting() {
	    // 정수 
		byte b = 10; // 1byte 
		short s = b; // 2byte
		int i = s ; // 4byte 
		long l = i; // 8 byte 
		// 작은 크기 변수들이 큰 크기를 가진 변수 공간에 들어가는것 
		
		// 실수 
		float f = 1; // 4byte 
		double d = f; // 8byte 
		
		
		d = i ; // int (정수) -> double (실수) 실수의 범위에 정수가 속해있기 때문 
		
		f = l ; // long( 8byte , 정수) - > float( 4byte, 실수 )
		// =>  표현 가능한 수의 범위가 더 크기 때문에 
		
		double result = 12 + 3.3;
		System.out.println(result);
		
		int result2 = b+s ; // byte ,short 타입의 데이터는 연산시 무조건 int타입으로 변환을 한다 
		System.out.println(result2);
		
		long result3 = 30 + 30 ; // 60을 long 타입으로 형 변환 
		System.out.println(result3);
		
		long result4 = 30+ 30L; 
		System.out.println(result4); // 문제없이 작동 
		
	}
	 /*
	  *  강제 형 변환 (명시적 형 변환)
	  *  
	  *  (자료형) (값)데이터 ;
	  *  
	  *  -  범위가 큰 크기의 자료형의 데이터를 작은 크기의 자료형으로 변환하려고 할 때 사용 
	  *  -  강제 형 변환의 경우 데이터의 손실이 발생할 수 있다.
	  *  
	  * */
	public void casting() {
		double d = 4.12345678901234567890; // 담아는 지는데 15자리만 출력  
		System.out.println(d);
		float f =(float) d; // float 은 소숫점 6자리 강제 형변환  4.123457
		System.out.println(f);
		
		int i =(int) f; // 정수로 강제 형변환 
		System.out.println(i);  // 4
		
		int sum = i + (int) d ; // 4+4 = 8
		System.out.println(sum);
		int sum2 =(int) (i+d);  
		System.out.println(sum2); // 4.0 + 4.12345645664  = > 정수로 
		
		int number = 129;
		byte bNumber = (byte) number ; //  -127   byte의 범위는 -128~127인데 2가 초과되어서 다시 처음부터 돌아간다 
		
		// char <-> int : 각 문자들 마다 고유한 숫자가 지정되어 있기 때문 ! (유니코드,아스키코드)
		// 쌍방향으로 가능 ! a~z 97~122 A~Z 65~90		
		// char는 음수값 저장 불가 = > 값의 범위가 0~65535가능 
		int num ='A';
		System.out.println(num); // 65 
		
		char ch = 52143;
		System.out.println(ch); // 쮯 
	}
	
	
	
}










