package com.kh.list.practice2.model;

import com.kh.list.model.Person;

public class Music implements Comparable<Music> {
	
	private String title;
	private String name;
	
	public Music(String title, String name) {
		super();
		this.title = title;
		this.name = name;
	}
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name+"-"+title  ;
	}
	
	@Override
	public int compareTo(Music o) {
		
	
		
		
		return this.name.compareTo(o.name);   
	}
	
	@Override
	public int compareTo(Music o) {
		
	 
		
		
		return this.title.compareTo(o.title);   
	}
	
	
	

}
