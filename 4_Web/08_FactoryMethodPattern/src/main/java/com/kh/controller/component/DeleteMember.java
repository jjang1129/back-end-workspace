package com.kh.controller.component;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteMember implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse responese) throws Exception {
		MemberDAO member = new MemberDAO();
		
		
		  HttpSession session = request.getSession();	  		  
		  Member mem =(Member)session.getAttribute("info");
		  
		
			if (member.deleteMember(mem.getId())) {
				session.invalidate();
				
				
				return new ModelAndView("/views/deleteMember.jsp") ;
			 } 
			
			return null;
	}

}
