package com.semi.youtube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.semi.youtube.model.vo.Member;

import mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper member;
	
	private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
	public boolean check(String id) {  // 입력할때마다 id 값을 받아서 
		Member vo = member.check(id); // mapper를 돌려서 select  
		if(vo!=null) {              // 입력받은 id로 select 값이 있을 경우 (중복일경우)
			return true;           // true 아닐 경우 false 리턴 
		} else {
			return false;
		}
		
		
	}
	
	public Member login(Member vo) {
		return member.login(vo);
	}
	
	public void signup(Member vo) {
		vo.setPassword(bcpe.encode(vo.getPassword()));
		member.signup(vo);
	}
	

}
