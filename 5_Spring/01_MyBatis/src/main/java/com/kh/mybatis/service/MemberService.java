package com.kh.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mybatis.model.vo.Member;

import mapper.MemberMapper;

@Service // 서비스 어노테이션 지정 
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;  // 멤버 매퍼가 필요해서 가져옴 
	
	
	public void register(Member member) {
		memberMapper.register(member);        
		
	}
	
	public Member search(String id) {
		
		return  memberMapper.search(id);
		
	}
}
