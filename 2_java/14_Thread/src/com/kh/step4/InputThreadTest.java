package com.kh.step4;

import javax.swing.JOptionPane;

// 프로세스 - 두 스레드 간의 Communication은 프로세스의 자원으로 해야 한다.

public class InputThreadTest {
	
	
	
	 boolean check = false;
	// 입력을하면 counting 종료 
	// counting이 종료되면 input이 종료 
	
	
	

	public static void main(String[] args) {
		
		 
		InputThreadTest  process = new InputThreadTest ();
		
		
		//1. 데이터 입력 작업 
		
     Input in = new Input(process);
     
     
     in.start();
     
     
     CountThread count = new CountThread(process);
     count.start();
     
		
		
		
		//2. 카운팅 작업
 //    Counting count = new Counting();
  //   count.start();
       
     
       //2. 카운팅 
  //   for(int i = 10; i>0; i--) {
  //  	if(process.check) {
  //  		break;
  //  	}
  //  	 try {
	//		Thread.sleep(1000);
	//	} catch (InterruptedException e) {
			
	//		e.printStackTrace();
	//	}
    //	 System.out.println(i);
   //  }
   //  if(!process.check) {
   // 	 System.out.println("10초 경과! 값 입력 중지!!");
   // 	 System.exit(0); // 강제 종료!
   //  }
     

	}

}
