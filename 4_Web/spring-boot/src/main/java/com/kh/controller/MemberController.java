package com.kh.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;
import com.kh.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	
	@Autowired
	private MemberService service;
	
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	
	
	@GetMapping("register")
	public void register() {
		
		
	}
	
	
	
	
	@PostMapping("register")
	public String register(Member vo) {
		try {
			service.register(vo);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "redirect:/";
	}
        
	
	@GetMapping("login")
	public void login() {}
	
	
	@PostMapping("login")
	public String login(Member vo, HttpServletRequest request) {
		
		
		try {
			
				
				Member mem = service.login(vo);
//						new Member(vo.getId(),vo.getPassword(),dao.memberName(vo.getId(), vo.getPassword()));
				
				
		if( mem.getName() != null) {		
			HttpSession session = request.getSession();
				
			session.setAttribute("info", mem);
				
			
				return "redirect:/";
		}		
			
				if(mem.getName() == null ) {
					
				return "loginFalse";
				
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return null;
	}
	
	@GetMapping("search")
	public void search() {}
	
	@GetMapping("find")
	public String find(@RequestParam("id")String id, Model model) {
		
	
		Member mem = null;
		
		try {
			mem = service.find(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		
				
		if(mem == null) {
			
			
			return "redirect:/fail";
			
			
		} else {
			
			
			
			model.addAttribute("member",mem);
			
			
			
		
			return "search_ok";
			
			
			
			
		}
		
		
		
		
	
}
	
	
	@GetMapping("fail")
	public String fail() {
		return "search_false";
	}
	
	@GetMapping("allMember")
	public String allMember(Model model) {
		
		
		  
		
		try {
			List<Member> list =service.allMember();
			  model.addAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    
		
	return "allMember";
		
		
		
	}
	
	@GetMapping("logout") 
     public String logout(HttpServletRequest request) {
	
			
		return service.logout(request);
	}
	
	
	@GetMapping("deleteMember")
	public String deleteMember(HttpServletRequest request) {
		
		
		  return service.deleteMember(request);
		
	}
	
	
}
