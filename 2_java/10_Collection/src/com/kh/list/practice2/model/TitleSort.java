package com.kh.list.practice2.model;

import java.util.Comparator;

public class TitleSort implements Comparator<Music> {
	
	 
	  
	
	

	public int compare(Music o1, Music o2) {
		
		
		 
			
			return o1.getTitle().compareTo(o2.getTitle());    
							
	}

}
