package com.kh.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor 
@Getter @Setter
public class ModelAndView {
	
	private String path; // 어떤 페이지로 ? 
	private boolean isRedirect; // forward or redirect? 
	
	// path만 가지는 생성자 
	
	public ModelAndView(String path) {
		this.path=path;
		this.isRedirect=false;
		
	}

}
