package com.kh.step4;

import javax.swing.JOptionPane;

public class Input extends Thread {
	
   InputThreadTest process;
  

	public Input (InputThreadTest process) {
		this.process = process;
	}
	
	
	
	public void run() {
		String input=JOptionPane.showInputDialog("최종로또 번호를 입력하세요 ...");
	     System.out.println("입력하신 숫자는 " + input + " 입니다.");
	     	     process.check = true;
	     
		
	}

}
