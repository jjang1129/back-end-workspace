package com.kh._abstract.step1;
//추상 클래스로 만듬 
public abstract class Sports {

	protected int numberOfPlayers; // 참여하는 사람 수 

	  // 생성자 
	public Sports(int numberOfPlayers) {
		
		this.numberOfPlayers = numberOfPlayers;
	}
	
	
	// 추상 메서드 
	// 자식 클래스에서 무조건 재정의 해주어야 함 
	public abstract void rule();
	
	
	
}
