package com.kh.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.model.Member;

import mapper.MemberMapper;

@Service
public class MemberService {
           
	@Autowired
	public MemberMapper mapper;
	
	 public Member idCheck(Member member) {
		return mapper.idCheck(member);
	 }
	 public void signUp(Member member) {
		  mapper.signUp(member);
	 }
	
}
