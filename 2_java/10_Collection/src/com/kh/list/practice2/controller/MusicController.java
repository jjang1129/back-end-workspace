package com.kh.list.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.list.practice2.model.Music;
import com.kh.list.practice2.model.TitleSort;

public class MusicController {

	ArrayList<Music> list = new ArrayList<Music>();
	ArrayList<Music> list2 = new ArrayList<Music>();
	ArrayList<Music> list3 = new ArrayList<Music>();

	
	public boolean addLast(Music music) {
		
		
		if(!music.getName().equals("") && !music.getTitle().equals("")) {
			list.add(music);
			return true;
		}else {
			return false;
			
		}
		     
		
		
	}
       public boolean addFirst(Music music) {
		
		
		if(!music.getName().equals("") && !music.getTitle().equals("")) {
			list.add(0,music);
			return true;
		}else {
			return false;
			
		}
		     
		
		
	}
       public void allMusic() {
    	   for(int i=0; i<list.size(); i++) {
    		   System.out.println(list.get(i));
    	   }
       }
	
       public Music searchMusic(String title) {
    	  for(int i=0; i<list.size(); i++) {
    		  if(list.get(i).getTitle().contains(title) ) {
    			return list.get(i);
    		  }
    	  }
    		  return null;
       
	


       }
}