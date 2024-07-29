package com.kh.controller.component;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse responese) throws Exception {
		
		MemberDAO member = new MemberDAO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	
				
			 if(member.login(id, password)) {
							
				// 로그인 정보를 세션이 담기 HttpSession 
				// 1) 세션을 하나 받아온다 
				Member mem = new Member(id,password,member.memberName(id, password));
				
				HttpSession session = request.getSession();
			
				
				// 2) 세션에 바인딩 하기 
				
				
				session.setAttribute("info", mem);
				
				
				return new ModelAndView("index.jsp",false);
			
				
			 } else {
				 
					
			
				
				
			
					
			return new ModelAndView("/views/login.jsp",true);
				
				 //response.sendRedirect("/views/loginFalse.jsp");
				 
				 
				 
		
		
		
		
		
	}
			 
		
		
		
		
		
		
	}

}
