package com.kh.array.practice3.member;

import com.kh.array.practice3.model.Book;

public class Member  {
   String name;
   int age;
   int coupon;
   
   
public Member(String name, int age, int coupon) {
	super();
	this.name = name;
	this.age = age;
	this.coupon = coupon;
}

public Member() {
	
	// TODO Auto-generated constructor stub
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
	return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + "]";
}
   
   
    
	
}
