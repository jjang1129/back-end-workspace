package com.kh.controller.component;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse responese) throws Exception {
		MemberDAO member = new MemberDAO();
		Member mem = new Member();
		String id =request.getParameter("id");
		
		
			mem = member.searchMember(id);
			
			
		
				
		if(mem == null) {
			
			
			return new ModelAndView("views/search_false.jsp");
			
			
		} else {
			
			
			request.setAttribute("member", mem);
			
			
			
		
			return new ModelAndView("views/search_ok.jsp");
			
			
			
			
		}
		
		
		
		
		
	}

}
