package com.kh.list.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.list.practice2.model.Music;
import com.kh.list.practice2.model.TitleSort;

public class MusicController {

	ArrayList<Music> list = new ArrayList<Music>();
	ArrayList<Music> list2 = new ArrayList<Music>();
	ArrayList<Music> list3 = new ArrayList<Music>();

	public void titleUp() {          // 곡명 오름 차순  C,B,A = > A,B,C
		Collections.sort(list3, new TitleSort());
		for(int i = 0; i <list3.size(); i++) {
			System.out.println(list3.get(i));
		
		}
	
	}
	
	

}