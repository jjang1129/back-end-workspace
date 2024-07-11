package com.kh.array.practice3.member.controller;

import java.util.Arrays;

import com.kh.array.practice3.model.Member;

public class MemberController {
	
	Member memberController = new Member ();
	
	
	public void add (String name,int age , int coupon) {
		
		memberController.setName(name);
		memberController.setAge(age);
		memberController.setCoupon(coupon);
		
	}

	
	public Member info() {
		System.out.println(memberController);
		return memberController;
	}
}
