package com.kh.loop;

import java.util.Scanner;

public class C_For {
      Scanner sc = new Scanner(System.in);
      /*
       *  for 문 
       *     초기식에 int가 주로온다 
       *  for(초기식; 조건식 ; 증감식) {
       *    실행 코드 
       * }
       * 
       * 
       * - 주어진 횟수만큼 코드를 반복 실행하는 구문 
       * - 초기식 : 반복문이 수행될 때 단 한번만 실행, 
       *          반복문안에서 사용할 변수를 선언하고 초기값 대입 
       * - 조건식 : 결과가 true 이면 실행 코드를 실행,
       *           false 이면 실행하지 않고 반복문을 빠져나감 
       * - 증감식 : 반복문에서 사용하는 변수의 값을 증감, 주로 증감 연산자 사용 
       *                   
       * */
      // 1~5까지 출력 
      public void method1() {
    	  
    	for(int num = 1; num <=5; num++) {
    		System.out.println(num);
    	}  
      }
      //1~5 반대로 출력 
      public void method2() {
    	  
      	for(int num = 5; num >=1; num--) {
      		System.out.println(num);
      	}  
        }
      
     // 1~10 사이의 홀수만 출력  
      
      public void method3() {
    	  
    	//  for(int num = 1; num <= 10 ; num++) {
    	//	  if(num%2 ==1) {
    	//		  System.out.println(num);
    	//	  }
    	//  }
    //	  for(int num = 1; num <= 10 ; num+=2) {
   // 		 
   // 			  System.out.println(num);
   // 		  
   // 	  }
    	  
    	  /*
    	   *  continue 문 
    	   *  - continue문은 반복문 안에서 사용 
    	   *  - 반복문 안에서 continue를 만나면 "현재 구문" 종료 
    	   *  - 반복문을 빠져나가는건 아님! 다음 반복문을 계속 수행 
    	   * */
    	  
    	  for(int num = 1; num <= 10 ; num++) {
    		  if(num%2 ==0) {
    			  continue;
    		  } System.out.println(num);
    	  }
    	    }
      
      // 1~10까지 합계 
      public void method4() {
    	   int a=0;
    	  for(int i=1; i<=10; i++) {
    		  a+=i;
    	  }
    	  System.out.println(a);
      }
      // 1부터 사용자가 입력한 수 까지의 합계 
      
      public void method5() {
    	  System.out.print("숫자를 입력하세요 : ");
    	  int number = sc.nextInt();
    	  int sum = 0;
    	  for(int i =1 ; i <= number; i++) {
    		  sum+=i;
    	  }System.out.println(sum);
      }
      
      // 1부터 랜덤값까지의 합계
      public void method6() {
    	  /*
    	   * java.lang.Math 에서 제공하는 random()메서드 
    	   * 호출할 때마다 매번 다른 랜덤값을 얻어낼 수 있음 
    	   * */
    	  double random = Math.random();
    	  random=Math.random()*10;  // 범위가 0.0 ~10으로 바뀜 
    	  random=Math.random()*10+1; // 1 ~ 11 
    	  System.out.println((int)random); // 정수로 바꿈 
    	  
    	  
    	  
    	
    	  int sum = 0;
    	  for(int i =1 ; i <= (int)random; i++) {
    		  sum+=i;
    	  }System.out.println(sum);
      }
      
      /*
       * 사용자한테 입력받은 문자열을 세로로 출력 
       * 
       * */
      
      public void method7() {
    	  System.out.print("문자열을 입력하세요 : ");
    	  String text = sc.nextLine();
    	  for( int i = 0; i<text.length(); i++) {
    		  System.out.println(text.charAt(i));
    	  }
    	  
    	  
    	  System.out.println();
    	  /*
    	   * 향상된 for문
    	   * for(데이터타입 변수 : 배열) { 
    	   *         변수 :  배열의 값을 하나씨 가지고옴 
    	   * 
    	   * }
    	   * 
    	   * 문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬것이 문자열 그러나 string은 자바에서는 배열이 아님 char[]꼴로 바꿔줘야 배열로 사용가능 
    	   * - String.charAt(int index) : 인데스에 있는 문자를 char 형식으로 반환 
    	   * - String.toCharArray (): 모든 문자가 들어있는 char[] 형식의 데이터 반환 
    	   * */
    	  
    	  char[] arr = text.toCharArray();    	  
    	   for(char ch : arr) {
    		   System.out.println(ch);
    		   
    	   }
    	   
    	  
    	  
    	  
      }
      // 구구단 - 2단 출력 
      public void method8() {
    	  System.out.println("2단 ");
    	  for(int i=1; i<=9 ; i++) {
    		  System.out.println("2 x "+i+" = "+2*i);
    		     	  }
      	  
      }
      
      public void method9() {
    	  
    	  
    	  
    	// 중첩 for문 
      	// 2~9단 출력 
    	    	   	   	  
      	  System.out.println("구구단");
      	  for(int j=2; j<=9; j++) {
      		  for(int z=1; z<=9; z++) {
      			  System.out.println(j+" x "+z+" = "+ j*z);
      		  }
      	  }
      	  
    	  for(int a = 3; a<= 100; a++) {
    		  for(int b = 2; b < a; b++  ) {
    			  if(a/b == 0) continue;
    				  
       			  
    			 
    		  }
    	  }
    	  
      }
      /*
       * *****
       * *****
       * *****
       * *****
       * */
      
      
      public void method10() {
    	  for(int num =0; num<4; num++ ) {
    		  for(int star=0; star<5; star++) {
    			  System.out.print("*");
    		  }  System.out.println();
    	  }  
    	 
    	 
      }
      /*
       * 1****
       * *2***
       * **3**
       * ***4*
       * ****5
       * 
       * 
       */
      
      
      public void method11() {
    	  
    	  for(int i=0; i<5; i++) {
    		  for(int j=0; j<5; j++) {
    			  if( i==j ) {
    				  System.out.print(i+1);
    				  
    			  } else {
    				  System.out.print('*');
    			  }
    			 
    			  
    		  } System.out.println();
    	  }
    	  
    	  
    	  
      }
      
     /*
      *  *
      *  **
      *  ***
      *  ****
      *  *****
      *  ******
      * */ 
      
      
      
      public void method12() {
    	  
    	  for(int i=0; i <6; i++) {
    		  for(int j = 0; j<=i; j++) {
    			  System.out.print('*');
    		  } System.out.println();
    	  }
    	  
    	  
      }
      
      
      /*        i,j  0,0 0,1 0,2 1,4 제외  4는 n열에서 j-n번째까지 제외 한다 
       *     *  0,4
       *    ** 1,3 1,4 
       *   *** 3,3 3,4 3,5
       *  ****
       * *****
       * 
       * 
       * */
      public void method13() {
    	  for(int i=0; i<5; i++) {
    		  for(int j= 4; j>=0; j--) {
    			  if( i < j) System.out.print(" ");
    			  }  System.out.println('*');
    		  } 
    	  }
    	
	public static void main(String[] args) {

		C_For c = new C_For();
		//c.method1();
		// c.method2();
		//  c.method3();
		//  c.method4();
		// c.method5();
		//   c.method6();
		//   c.method7();
		//     c.method8();
		//    c.method9();
		//  c.method10();
		// c.method11();
		//   c.method12();
		    c.method13();
	}

	
/*    	*    
	  *   *
	*       *
	*  	    *
	*       *
	*********
	      
 *
*
*
*
*
*
*/
	
	
	
	
}
