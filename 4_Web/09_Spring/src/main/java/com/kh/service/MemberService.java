package com.kh.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	
	
	
	
	
	
	
	public void register(Member vo) throws SQLException {
		
			dao.insertMember(vo.getId(),vo.getPassword(),vo.getName());
	
		
	}
        
	public Member login(Member vo ) throws SQLException {
		
		
		
			
		Member mem = new Member(vo.getId(),vo.getPassword(),dao.memberName(vo.getId(), vo.getPassword()));
				
		     return mem ;
	}
			
	


	public Member find(String id) throws SQLException {
		
	
		Member mem = null;
		
		
			mem = dao.searchMember(id);
        
			return mem;
		
		
	
}
	
	

	
	

	public List<Member> allMember() throws SQLException {
		
		
		  
		
		
			ArrayList<Member> list =dao.searchAll();
			return list ;
		
   	
	}
	
	
     public String logout(HttpServletRequest request) {
	HttpSession session= request.getSession();
		
		Member member=(Member)session.getAttribute("info");
		
		session.invalidate();
		
		
		return "redirect:/";
	}
	

     
 	public String deleteMember(HttpServletRequest request) {
 		
 		
 		
 		  HttpSession session = request.getSession();	  		  
 		  Member mem =(Member)session.getAttribute("info");
 		  
 		
 			try {
 				if (dao.deleteMember(mem.getId())) {
 					
 					session.invalidate();
 					
 					
 				 }
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} 
 			
 			return "redirect:/";
 		
 	}
	
	

}
