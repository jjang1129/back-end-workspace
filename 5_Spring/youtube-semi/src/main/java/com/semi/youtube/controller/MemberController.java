package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.youtube.config.TokenProvider;
import com.semi.youtube.model.vo.Member;
import com.semi.youtube.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;


@Controller //컨트롤러 명시 
public class MemberController {
	//필요할거같은 기능들 주석으로 걸기 
	@Autowired
	private MemberService member;	
	
	@Autowired
	private TokenProvider tokenProvider; 
	// 토큰 생성기 가져옴 
	
	//중복체크 
	@ResponseBody
	@PostMapping("/check")
	public boolean check(String id) {
		System.out.println(id);
		return member.check(id);
		
	}
	
	//회원가입 
	
	@PostMapping("/signup")
	public String signup(Member vo) {
		member.signup(vo);
		return "redirect:/";
	}
	
	
	// 로그인 
	@ResponseBody
	@PostMapping("/login")
	public String login(Member vo, HttpServletRequest request) {
		Member result= member.login(vo);
		if(result != null ) {
		//	HttpSession session = request.getSession();
		//	session.setAttribute("vo", result);
			String token=tokenProvider.create(result);
			System.out.println("토큰 :"+ token);
			return token;
		}
		return null;
	}
	
	
	// 로그아웃 
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
		
	}
	
	

}
