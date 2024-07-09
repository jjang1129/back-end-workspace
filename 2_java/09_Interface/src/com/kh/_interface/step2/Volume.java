package com.kh._interface.step2;

public interface Volume {

	// 인터페이스 구성요소 = 상수 + 추상 메서드 
	
	// 인터페이스에서 멤버 변수는 무조건 상수!
	/*public static final*/ int max_volume =10;
	int min_volume = 0;
	
	//인터페이스에서 메서드는 무조건 추상 메서드!
	/*public abstract*/ void setVolume(int volume);
	
}
