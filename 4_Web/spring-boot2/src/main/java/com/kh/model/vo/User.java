package com.kh.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@Data 
@NoArgsConstructor
public class User {
	
	private String userName ;
	private double userManner;
	private Member member;
	

}
