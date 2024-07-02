package com.kh.array;

import java.util.Arrays;
import java.util.Collections;

public class C_sorting {

	
	
	public void method1() {
		
		int[] arr = {7,5,9,0,3,1,6,2,4,8};
		//1. 오름차순 정렬 ( 작은숫자부터 큰 숫자로 정렬)
		Arrays.sort(arr); // Dual-pivot QuickSort
		System.out.println(Arrays.toString(arr));
		
		//2. 내림차순 정렬 - > 원본 배열을 오름차순 정렬한 다음 값을 
		//                 반대로 새로운 배열에 대입 
	   int[] copy = new int[arr.length];
	   for(int i = 0; i<arr.length; i++) {
		   copy[arr.length-1-i] =arr[i];
	   }
		System.out.println(Arrays.toString(copy));
	}
	
	
	public void method2() {
		
		String[] arr = {"사과","Orange", "배", "banana", "Lemon", "kiwi"};
	// 오름차순 정렬  (영문 대문자 - 소문자 - 한글 순으로 정렬) 
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	// 내림 차순 정렬
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));
	}
	
	public void method3() {
		int [] score = {79,88,91,44,100,55,95};
		Arrays.sort(score);
		System.out.println("최소값 : "+score[0]);
		System.out.println("최대값 : "+score[score.length-1]);
		
		
		
	}
	/*
	 * 선택정렬 
	 * 
	 * 
	 * */
	
	/*
	 * 삽입정렬
	 * */
	
	/*
	 * 버블 정렬 
	 * */
	public static void main(String[] args) {

		C_sorting c = new C_sorting ();
	//	c.method1();
	//	c.method2();
		c.method3();
	}

}
