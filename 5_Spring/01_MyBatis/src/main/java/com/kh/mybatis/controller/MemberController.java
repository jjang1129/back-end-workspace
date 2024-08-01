package com.kh.mybatis.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // 모델은 이거로 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller  // 컨트롤러라고 인식을 시켜준다 
public class MemberController {
          
	@Autowired
	 private MemberService service;
	 
	
	 
	 @GetMapping("/")
	 public String index(Model model) {
		model.addAttribute("allMember", service.allMember());	 
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
	 
	@GetMapping("/login")
	public String login() {
		
		return "mypage/login";
	}
	
	@PostMapping("/login")
	public String login(Member vo,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("vo", service.login(vo));
		
		return "redirect:/";
	}

	 @PostMapping("/update")
	 public String update(Member vo,HttpServletRequest request) {
		 HttpSession session = request.getSession();
		 
		 Member member = (Member) session.getAttribute("vo");
		 if(vo.getId() == null )  vo.setId(member.getId());	
		 service.update(vo);
	
		
		if(vo.getName()== null) vo.setName(member.getName());
		
		
		session.setAttribute("vo",vo);
		
		System.out.println(vo);	 
		 return "redirect:/";
	 }
	 
	
	 
	 

	 @GetMapping("/logout")
	 public String logout(HttpServletRequest request) {
		 HttpSession session = request.getSession();
		 Member member = (Member) session.getAttribute("vo");
		 if(member != null) session.invalidate();
	
		 
		 return "redirect:/";
	 }
	 
	 
	 @GetMapping("/search")
	 public String search(SearchDTO dto,Model model) {
		 
	//	 System.out.println(select); // 검색 범위 id , name , all 
	//	 System.out.println(keyword); // 내가 입력한 값 
	//	 service.search(select,keyword);
	//	 model.addAttribute("select",dto.getSelect());
	//	 model.addAttribute("keyword",dto.getKeyword());
		 model.addAttribute("Member", service.search(dto));	
		 
		 return "index";
	 }

	 @PostMapping("/delete")
	 // 체크박스는 필수 입력값이라 체크를 하나도 안하고 보내면 에러가 떠서 
	 // 해당 값을 필수값이 아니게끔 바꿔줘야 한다 required = false 
	 // @RequestParam  을 왜 ? 
	 public String delete(@RequestParam(name="idList",required=false) List<String> idList) {
		 System.out.println(idList);
		 
	//	for(int i=0; i<idList.size(); i++) {
	//	    service.delete(idList.get(i));
	//	}
		 
		if ( idList != null)  service.delete(idList);
		 
		 
		 
		 return "redirect:/";
	 }
	 
	 
	 
}
