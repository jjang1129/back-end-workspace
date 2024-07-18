package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Book {
	
	   private int bkNo ; 
	   private  String bkTitle;
	    private  String  bkAuthor;
	    private   int  bkPrice;
	    private    int    bkPubNo;
	

}
