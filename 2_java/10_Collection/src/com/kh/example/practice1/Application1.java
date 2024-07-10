package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collections;

public class Application1 {

	public static void main(String[] args) {
	

		 ArrayList<Integer> lotto = new ArrayList<Integer>();
		 
		
		 
		 while( lotto.size() < 6) {
			 
			 int num = (int)(Math.random()*45+1);
			if( !lotto.contains(num)) {
			 lotto.add(num);
			} 
		}
		 // 0~6까지 범위 지정해서 로또 6개 따로 지정 
		 ArrayList<Integer> lottoList = new ArrayList<Integer>();
		 
		 while(true) {
			 ArrayList<Integer> myLotto = new ArrayList<Integer>();
			 
			 while(myLotto.size()<6) {
				 int num = (int)(Math.random()*45+1);
				 if(!myLotto.contains(num)) {
					 myLotto.add(num);
				 }
			 }
			 
			 System.out.println("로또 번호 : " +lotto);
			 System.out.println("내 번호 : " +myLotto);
			 
			 Collections.sort(lotto);
			 Collections.sort(myLotto);
			 // 멈추는 조건! 로또 번호와 내 번호가 정확히 일치! 1등 당첨!
			 if(lotto.equals(myLotto)) {
				 break;
			 }
		 }
		 
		
	}
	}


