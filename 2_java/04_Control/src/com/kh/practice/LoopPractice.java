package com.kh.practice;

import java.util.Scanner;

class LoopPractice {
	Scanner sc =new Scanner(System.in);
	public static void main(String[] args) {
		LoopPractice a = new LoopPractice();
	//	a.method1();
	//	a.method2();
	//	a.method3();
	//	a.method4();
	//	a.method5();
		a.method6();
	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("숫자를 입력하세요 (1~100) : ");
    	int num =sc.nextInt();
    	for(int i=num; i>=1; i-- ) {
    		System.out.println(i);
    	}
    	
    	
    	
    	

    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    // 홀수면 더하고 짝수면 빼기 100이 될때까지 
    // 이때의 홀수값? 
    	 int sum=0;
    	for(int i = 1; i<200; i++) {
    		if(i%2 ==1) {
    			sum+=i;
    		}else {
    			sum-=i;
    		}
    	}  System.out.println(sum);
    	
    	
        int sum1=0;
    	int i=0;
    	while (true) {
    		
    		if (i%2 == 1) {
    			sum1+=i;
    		} else if(i%2 == 0) {
    			sum1-=i;
    		} 
    		
    		
    		
    		if(sum1 == 100) {
    			System.out.println(i);
    			break;
    		} 
    	
    		i++;
    		
    	
    	}
    	
    	
    	
    	
    	
    
      
  
    }

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.print("문자열 : ");
    	String text =sc.nextLine();  // aaaa
    	System.out.print("문자 : ");   // a
    	char text1 = sc.nextLine().charAt(0);
    	
    	int count = 0;
    	for(int i=0; i <text.length(); i++) {
    		if(text1 == text.charAt(i) ) {
    			count++;   			
    		} 
    	} 
    	System.out.println(text+ "안에 포함된"+ text1+" 개수 : "+(count) );
    	

    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    
    	
    
    	
    	while (true) { 	
    		double number =(int)(Math.random()*11);
    		if(number == 7) {
    			System.out.println(number);
    			break;
    		} else {
    			System.out.println(number);
    		}
    			
    			
    		
    	}
    	
    	
    	
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
    	
        int count1 =0;
        int count2 =0;
        int count3 =0;
        int count4 =0;
        int count5 =0;
        int count6 =0;

         for(int i = 0; i <10; i++) {
          double number = (int) (Math.random()*6+1);
          if( number == 1) {
        	  count1++;
          } else if (number == 2) {
        	  count2++;
          } else if (number == 3) {
        	  count3++;
          }else if (number == 4) {
        	  count4++;
          } else if (number == 5) {
        	  count5++;
          } else if (number == 6) {
        	  count6++;
          }
         }
         
         
        
          System.out.println("1의 갯수 : "+ count1);
          System.out.println("2의 갯수 : "+ count2);
          System.out.println("3의 갯수 : "+ count3);
          System.out.println("4의 갯수 : "+ count4);
          System.out.println("5의 갯수 : "+ count5);
          System.out.println("6의 갯수 : "+ count6);
         
          
        	  
          
          
          
        	 
             	 
    }

    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    public void method6() {
    	
        System.out.print("당신의 이름을 입력해주세요 : ");
        String name = sc.nextLine();
        int count1=0;
        int count2=0;
        int count3=0 ;
        
        while (true) {
        	   System.out.print("가위바위보: ");
               String num1 = sc.nextLine();
          double number = (int) (Math.random()*3+1);
               if( number== 1) {
            	   System.out.println("컴퓨터 : 가위");
               }else if (number == 2) {
            	   System.out.println("컴퓨터 : 바위");
               }else {System.out.println("컴퓨터 : 보");}
        	
        	if(num1.equals("가위") && number == 1 ) {
        		System.out.println("비겼습니다.");
        		count1++;
        	} else if (num1.equals("가위") && number == 2 ) {
        		System.out.println("졌습니다 ㅠㅠ");
        		count2++;
        	} else if(num1.equals("가위") && number == 3 ) {
        		System.out.println("이겼습니다!!");
        		count3++;
        		System.out.println("비긴횟수 : "+ count1 + " 진 횟수 : "+count2+ " 이긴 횟수 : "+count3);
        		break;
        	}
         	
        	if(num1.equals("바위") && number == 2 ) {
        		System.out.println("비겼습니다.");
        		count1++;
        	} else if (num1.equals("바위") && number == 3 ) {
        		System.out.println("졌습니다 ㅠㅠ");
        		count2++;
        	} else if(num1.equals("바위") && number == 1 ) {
        		System.out.println("이겼습니다!!");
        		count3++;
        		System.out.println("비긴횟수 : "+ count1 + " 진 횟수 : "+count2+ " 이긴 횟수 : "+count3);
        		break;
        	}
         	
        	if(num1.equals("보") && number == 3 ) {
        		System.out.println("비겼습니다.");
        		count1++;
        	} else if (num1.equals("보") && number == 1 ) {
        		System.out.println("졌습니다 ㅠㅠ");
        		count2++;
        	} else if(num1.equals("보") && number == 2 ) {
        		System.out.println("이겼습니다!!");
        		count3++;
        		System.out.println("비긴횟수 : "+ count1 + " 진 횟수 : "+count2+" 이긴 횟수 : "+count3);
        		break;
        		
        	}
      
        } 
        
    };
    
     
        
     

}