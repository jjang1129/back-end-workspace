package com.semi.youtube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.semi.youtube.model.vo.Member;

import mapper.MemberMapper;

//Spring Security에서 제공하는 UserDetailService 인터페이스 상속 

@Service
public class MemberService implements UserDetailsService {
	
	@Autowired
	private MemberMapper member;
	
	@Autowired
	private PasswordEncoder bcpe;
	
	public boolean check(String id) {  // 입력할때마다 id 값을 받아서 
		Member vo = member.check(id); // mapper를 돌려서 select  
		if(vo!=null) {              // 입력받은 id로 select 값이 있을 경우 (중복일경우)
			return true;           // true 아닐 경우 false 리턴 
		} else {
			return false;
		}
		
		
	}
	
	
	
	public void signup(Member vo) {
		vo.setPassword(bcpe.encode(vo.getPassword()));
		member.signup(vo);
	}

	
	@Override  //로그인하면 일로옴  
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("로그인 성공!!!");
		System.out.println("유저네임 : " + username);
		System.out.println(username);
		return member.check(username);
	}
	

}
