package com.kh.step2;

import com.kh.step2.model.Card;

public class Application {

	public static void main(String[] args) {
   // 클래스 변수는 객체 생성 없이 호출 가능하다 
		System.out.println(Card.width);
		System.out.println(Card.height);
	// 인스턴스 변수는 객체 생성 후에 접근 가능 	
		Card card1 = new Card();
		card1.kind = "Heart";
		card1.number= 7;
		
	
		Card card2 = new Card();
		card2.kind = "Spade";
		card2.number=3;
		
		
		
		
		// 클래스 변수는 모든 객체가 하나의 저장공간을 공유하므로 항상 공통된 값을 갖는다.
		Card.width=50;		
		card2.height=90;  //card2 뿐만 아니라 card1도 같이 바뀜 
		
		
		System.out.println("첫번째 카드는 " + card1.kind+ " "+card1.number+ "이며, "
				+ "크기는 " + card1.width + "x" + card1.height +"입니다.");
		
		
		System.out.println("두번째 카드는 " + card2.kind+ " "+card2.number+ "이며, "
				+ "크기는 " + card2.width + "x" + card2.height +"입니다.");
	}

}
