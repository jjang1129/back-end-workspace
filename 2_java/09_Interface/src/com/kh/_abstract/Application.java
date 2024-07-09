package com.kh._abstract;

import com.kh._abstract.step1.BasketBall;
import com.kh._abstract.step1.FootBall;
import com.kh._abstract.step1.Sports;
import com.kh._abstract.step2.BulgogiPizza;
import com.kh._abstract.step2.Pizza;
import com.kh._abstract.step2.PotatoPizza;
import com.kh._abstract.step2.pineApplePizza;

/*
 * 추상 클래스 (Abstract Class)
 * [접근제어자] abstract class 클래스명{}
 * 
 * - 미완성 클래스로 추상 메서드를 포함한 클래스 
 * - 미완성 클래스이기 때문에 new 연산자를 통해서 객체 생성 x 
 * - 일반적인 멤버(변수,메서드) 포함 가능 (변수 + 메서드 + 추상 메서드)
 * - 객체 생성을 할 수 없지만 참조형 변수 타입으로는 사용 가능 
 * - 상속관계로 구성되어 있으면 다형성 적용 가능  
 * 
 * 추상 메서드 (Abstract method)
 * [접근제어자] abstract 반환타입 메서드명(매개변수);
 * 
 * - 미완성 메서드로 중괄호{}가 없어짐 
 * - 추상 클래스를 상속받는 자식 클래스에서 "반드시" 오버라이딩(재정의)
 * - 오버라이딩 (재정의) 해주지 않으면 컴파일 에러 발생 
 * - 자식 클래스에 강제성을 부여함 
 * */

public class Application {

	public static void main(String[] args) {
		
		Sports b= new BasketBall(9);
		FootBall f= new FootBall(11);
	// 다형성이 적용된다 조건을 만족해도 안될경우 강제로 임포트를 해본다

	// 추상 클래스는 객체 생성 불가능 
		b.rule();
		f.rule();
		// 피자 관련된 출력 과정
		
		
		
		Pizza [] pizza = {
				new BulgogiPizza(30000,"피자헛"),
				new PotatoPizza(20000,"도미노피자"),
				new pineApplePizza(10000,"잭슨피자")
				
		};
		
		for(Pizza p : pizza) {
			p.makePizza();
		}
		
		

		/*
		 * 피자헛의 불고기 피자 가격은 30000원
		 * 피자 반죽과 함께 도우를 빚다.
		 * 토핑은 불고기를 포함시킨다
		 * 피자를 180도에서 10분간 구운다.
		 * 피자를 8등분으로 자른다.
		 * 피자를 포장한다.
		 * 
		 * 
		 * 도미노피자의 포테이토 피자 가격은 20000원
		 * 피자 반죽과 함께 도우를 빚다.
		 * 토핑은 감자를 포함시킨다
		 * 피자를 180도에서 10분간 구운다.
		 * 피자를 8등분으로 자른다.
		 * 피자를 포장한다.
		 * 
		 * 잭슨피자의 파인애플 피자 가격은 10000원
		 * 피자 반죽과 함께 도우를 빚다.
		 * 토핑은 파인애플을 포함시킨다
		 * 피자를 180도에서 10분간 구운다.
		 * 피자를 8등분으로 자른다.
		 * 피자를 포장한다.
		 * 
		 * 
		 * 
		 * 
		 * */
	}

}
