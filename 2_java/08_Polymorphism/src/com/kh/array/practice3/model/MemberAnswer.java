package com.kh.array.practice3.model;

import java.util.Arrays;

public class MemberAnswer {
	
	private String name;
	private int age;
	private int coupon;
	private BookAnswer[] bookList = new BookAnswer[2];
	
	public MemberAnswer(String name, int age, int coupon, BookAnswer[] bookList) {
		super();
		this.name = name;
		this.age = age;
		this.coupon = coupon;
		this.bookList = bookList;
	}

	public MemberAnswer() {
		super();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public BookAnswer[] getBookList() {
		return bookList;
	}

	public void setBookList(BookAnswer[] bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "MemberAnswer [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ Arrays.toString(bookList) + "]";
	}
	
	
	
	
	

}
