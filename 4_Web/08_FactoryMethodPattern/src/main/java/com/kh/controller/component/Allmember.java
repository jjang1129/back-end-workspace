package com.kh.controller.component;

import java.util.ArrayList;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Allmember implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse responese) throws Exception {
		MemberDAO member = new MemberDAO();
		
		  
		ArrayList<Member> list =    member.searchAll();
		
		
           request.setAttribute("list", list);
		
		
		
		

		
	return new ModelAndView("/views/allMember.jsp");
	}

}
