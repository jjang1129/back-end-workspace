package com.kh.step1.model;
 /*  MVC패턴 가장기초패턴 
  * 
  *  M  Model : 테이블 1개 코드화 시키는것 속성(변수), 기능(메서드)이 들어감 
  *  V  View : 프런트앤드 파트, 화면단을 뜻한다 보여지는 역할을 책임진다
  *  C  Controller : 기능개발 
  *  
  * */
public class Tv {
	// 클래스는 속성과 기능으로 쪼개진다 
	
	// TV 기능이 더 있지만 당장 프로그램밍화 하는데 필요한 속성과 기능만 
	// 선택하여 작성하는 것을 추상화!
	
     // 1.속성 (propety) : 멤버변수 (member variable), 특성(attribute) 특성과 속성은 같은말, 필드 (field) 
	 public boolean power; // 전원상태 (on/off) boolean 값으로 켜졌나 꺼졌나 상태를 특정해 담아내는 변수 지정  
	 public int channel ; // 채널 번호를 담아내는 변수 지정 
	
	
	 // 2.기능 (fuction) : 메서드(method), 함수(function) 메서드와 함수는 같은말
	public void power() { // 위에 power변수와 이름은 같지만 얘는 메서드 
		// 
		power = !power; // TV가 꺼져있을때는 키고 켜졌일때는 끄는 기능 전원동작
		
	}
	public void channelUp() { 
		++channel; // 채널 번호를 높이는 기능 
	}
	public void channelDown() {
		--channel; // 채널 번호를 내리는 기능 
	}
	
	
	
	
	
}
