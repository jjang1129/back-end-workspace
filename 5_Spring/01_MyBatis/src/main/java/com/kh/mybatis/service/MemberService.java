package com.kh.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

import mapper.MemberMapper;

@Service // 서비스 어노테이션 지정 
public class MemberService {
	
	@Autowired
	private MemberMapper Mapper;  // 멤버 매퍼가 필요해서 가져옴 
	
	
	public void register(Member member) {
		Mapper.register(member);        
		
	}
	
	public List<Member> allMember() {
		
	  return Mapper.allMember();
	}
	
	public Member login(Member member) {
		
		return Mapper.login(member);
		
	}
	
	public void update(Member member) {
	
		Mapper.update(member);
		
	}
	
	public List<Member> search(SearchDTO dto){
		
		return Mapper.search(dto);
	}
	
	public void delete(List<String> idList) {
		
		
			Mapper.delete(idList);
		
	}
	
	
}
