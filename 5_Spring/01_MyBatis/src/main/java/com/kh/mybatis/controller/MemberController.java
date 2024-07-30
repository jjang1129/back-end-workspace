package com.kh.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

@Controller  // 컨트롤러라고 인식을 시켜준다 
public class MemberController {
          
	@Autowired
	 private MemberService service;
	 
	
	 
	 @GetMapping("/")
	 public String index() {
		 return "index";
	 }
	 
	 
	 @GetMapping("/register")
	 public String register() {
		 return "mypage/register";
	 }
	 
	 
	 @PostMapping("/register")
	 public String register(Member vo) {
		 service.register(vo);
		 return "redirect:/";
		 
	 }
	 
	 
	 @GetMapping("/search")
	 public String search(String id,Model model) {
		 Member member = null;
		member = service.search(id);
		model.addAttribute("mem",member);
		 return "mypage/search";
	 }
	 
	 
	
	 
	 
	 
}
