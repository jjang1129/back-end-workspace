package com.kh.loop;

import java.util.Scanner;

public class D_While {
      
	Scanner sc = new Scanner(System.in);
	
	/*
	 *  while 문
	 * 
	 * while(조건식) {
	 *    조건이 true일 경우 계속 실행 
	 * }
	 * 
	 * */
	
	// 1~5까지 출력 : for -> while 
	public void method1() {
		
		for(int i=1; i<=5; i++) {
			System.out.println(i);
		}
		
		int i=1;
		while ( i<=5) {
			System.out.println(i);
			i++;
		}
		
		
	}
	
	/*
	 * 
	 * 무한루프 & break 문 
	 * - switch, 반복문의 실행을 중지하고 빠져나갈떄 사용 break 
	 * - 반복문이 중첩되는경우 break문이 포함되어 있는 반복문에서만 빠져나간다. 
	 * 
	 * 
	 * */
	public void method2() {
		while(true) {
			System.out.print("숫자 입력 : ");
			int num = sc.nextInt();
			System.out.println(num);
			int count=0; count ++;
			
			if( num == 0) {
				System.out.println(count); 
				break;
			}
				
			
		}
		
		
		
	}
	
	/*
	 * do{
	 * 
	 *     실행코드 
	 * } while (조건식);
	 * - 조건과 상관없이 무조건 한번은 실행
	 * - 거의안씀 
	 * 
	 * */
	public void method3() {
		int number = 1 ;
		
		while( number == 0) {
			System.out.println("while");
		}
		do {
			System.out.println("do-while");
		} while(number == 0);
		
	}
	/*
	 * 숫자 맞히기 게임
	 * 1과 100사이의 값을 입력해서 임의로 지정한 (Random)값을 맞히면 게임 끝
	 * 게임이 끝나면 몇 번만에 맞혔는지 출력! 
	 * 
	 * (예 : 57) 
	 * 1과 100사이의 값 입력 >  35
	 * 더 큰 수를 입력하세요 .
	 * 1과 100사이의 값 입력 > 70
	 * 더 작은 수를 입력하세요. 
	 * 1과 100사이의 값 입력 > 57
	 * 3번 만에 맞혔습니다.
	 * 
	 * */
	
	
	public void method4() {
		// int random =(int) math.random() ; 이렇게 하면 바로 정수 랜덤 
		 double random = Math.random()*100+1;
		 System.out.println((int)random);
		
		int count =0;
		while (true) {
			System.out.print("1과 100사이의 값 입력 >");		
			int i = sc.nextInt();
			 count++;			
			if(i > (int)random) {
				System.out.println("더 작은 수를 입력하세요");
							
			} else if ( i < (int)random) {
				System.out.println("더 큰 수를 입력하세요");	
				
			} else {			
				System.out.println(count +"번만에 맞췄습니다!!");
				break;
			}
			 
			}
		
		
		
	}
	/*
	 * 
	 * ----------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ----------------------------------
	 * 선택 > 1 
	 * 예금액 5000
	 * ----------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ----------------------------------
	 * 선택 > 2
	 * 출금액 > 2000(입력하는것)
	 * ----------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ----------------------------------
	 * 선택 > 3 
	 * 잔고 > 예금 -출금 = 잔고 
	 * ----------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ----------------------------------
	 * 선택 4
	 * 프로 그램 종료 
	 * 
	 * 
	 * */
	public void method5() {
		
		int balance = 0;
		
	while(true) {
		System.out.println("----------------------------------");
		System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
		System.out.println("----------------------------------");
		System.out.print("선택 : ");
		int num = sc.nextInt();
		
		if( num==1 ) {
					System.out.print("예금액 :  ");
				balance+=sc.nextInt();
				//balance=bac.nextlance+sInt()
		} else if(num == 2 ) {
			
			System.out.print("출금액 : ");
			 balance-= sc.nextInt();			
			 
		}else if( num == 3) {
			
			System.out.println("잔고 : " + balance);
			
		}else if(num == 4) {
			
			System.out.println("프로그램 종료");
			break;
				}	
	}
	
		}
	
	public void method55() {
		int balance = 0;
			int num =0;
		while(num != 4) {
			System.out.println("----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------------------------");
			System.out.print("선택 : ");
			 num = sc.nextInt();
		
		switch(num) {
		case 1 :
			System.out.print("예금액 :  ");
			balance+=sc.nextInt();
		     break;
		case 2 :
			System.out.print("출금액 : ");
			 balance-= sc.nextInt();	
			 break;
		case 3 :
			System.out.println("잔고 : " + balance);
			break;
		case 4 :
			System.out.println("프로그램 종료");
			break;
		  
		
		
		    }
	}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
         D_While d = new D_While();
   //      d.method1();
   //      d.method2();
   //      d.method3();
   //      d.method4();
    //      d.method5();
           d.method55();
	}

}
