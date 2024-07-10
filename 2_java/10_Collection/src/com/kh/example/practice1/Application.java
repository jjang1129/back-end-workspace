package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.kh.list.model.Person;

public class Application {

	
	public static void main(String[] args) {
		
		int [] nums = new int[7];
		
		
		for(int i =0; i<6; i++) 	{	
			 			
				nums[i] =(int)(Math.random()*45+1);	
				
				for(int j =0; j<i; j++) {
					if( nums[i] == nums [j]) {
						i--;
						break;
					}
				}
			}		
		for(int i =6; i<7; i++) 	{	
 			
			nums[i] =(int)(Math.random()*45+1);	
			
			for(int j =0; j<i; j++) {
				if( nums[i] == nums [j]) {
					i--;
					break;
				}
			}
		}	
		int count2=0;
		 int point =0;
		 int count = 0;
		while (count < 3) {
			count = 0;
			int [] nums2 = new int[7];
			for(int i =6; i<7; i++) 	{	
	 			
				nums2[i] =(int)(Math.random()*45+1);	
				
				for(int j =0; j<i; j++) {
					if( nums2[i] == nums2 [j]) {
						i--;
						break;
					}
				}
			}	
			
			
			
			
			
			
			for(int i =0; i<6; i++) 	{	
				 			
					nums2[i] =(int)(Math.random()*45+1);	
					
					for(int j =0; j<i; j++) {
						if( nums2[i] == nums2 [j]) {
							i--;
							break;
						}
					}				
			}	
		
			
			for(int i=0; i<6; i++) {
				for(int j=0; j<6; j++) {
					if (nums[i] == nums2[j]) {
						count ++;
					}
				}
			}
			if(count == 5) {
				count2++;
			}
			
		
			
			
			System.out.println("로또 번호 : " +Arrays.toString(nums));
			System.out.println("내 번호 : " +Arrays.toString(nums2));
			System.out.println("맞춘 번호 수 :"  +count);
			System.out.println("2등 횟수 : "+ count2);
			point++;
			System.out.println(" 시행횟수: " +point);
			
		}  
		
		
				
		
		
		
	
 	}
	
}
