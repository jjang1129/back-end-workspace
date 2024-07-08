package com.kh.array.practice1;

import java.util.Arrays;

import com.kh.array.practice1.model.Student;

public class Application {

	public static void main(String[] args) {
	         Student[] arr = new Student[5];
	         arr[0]= new Student ("박성철","자바",100);
	         arr[1]= new Student ("이진우","디비",95);
	         arr[2]= new Student("이준용","자바",97);
	         arr[3]= new Student ("김경주","화면",98);
	         
	       
	         
	         System.out.println(Arrays.toString(arr));
	       
	         //기본 for문 
	         for( int i = 0; i < arr.length; i++) {
	        	 System.out.println(arr[i]);
	         }
	         System.out.println();
	         
	         // 향상된 for문 
	         for( Student student: arr) {
	        	 System.out.println(student);
	         }

	}

}
