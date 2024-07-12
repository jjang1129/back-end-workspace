package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.OptionalDouble;

public class D_Looping {

	
	
/*
 *  반복 
 *  
 *  - 요소 전체를 반복하는 역할 
 *  - peek : 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용 
 *  - forEach : 최종 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용 
 *  
 * 
 * */	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		int [] values = {1,2,3,4,5};
		
		// peek
		
		int sum = Arrays.stream(values).filter(num -> num%2 == 0).peek(num->System.out.println(num)).sum();
		
		System.out.println(sum); 
		
		// forEach
		
		int sum2 = Arrays.stream(values).filter(num -> num%2 == 0).sum();
		
		Arrays.stream(values).filter(num -> num%2 == 0).forEach(n -> System.out.println(n));
		System.out.println(sum2);
				                                                     
		
		

	}

}
