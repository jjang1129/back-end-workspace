package com.kh.array.practice3.member;

import java.util.Arrays;

import com.kh.array.practice3.model.Book;

public class Member extends Book {
	private   String name;
	private  int age;
	private  int coupon;
	private Book[] bookList = new Book[2];
   
   
public Member(String name, int age, int coupon,Book[]  bookList) {
	super();
	this.name = name;
	this.age = age;
	this.coupon = coupon;
	this.bookList = bookList;
}

public Member() {
	
	
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

@Override
public String toString() {
	return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList=" + Arrays.toString(bookList)
			+ "]";
}


   
   
    
	
}
