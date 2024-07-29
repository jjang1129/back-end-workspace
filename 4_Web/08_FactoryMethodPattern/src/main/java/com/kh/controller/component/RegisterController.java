package com.kh.controller.component;

import java.io.IOException;
import java.sql.SQLException;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 *  컴포넌트
 *  
 *  - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스
 * */

public class RegisterController implements Controller{
	
	

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse responese) throws Exception {
		
		
		MemberDAO member = new MemberDAO();
		
		String id = request.getParameter("id"); 
		
		String name= request.getParameter("name");
		
		String password = request.getParameter("password");
		
		
		
			if(	member.memberName(id, password) == null ) {
				
				member.insertMember(id, password, name);
				return new ModelAndView("index.jsp",true);
			} else {
				return new ModelAndView("/views/sameid.jsp",true);
			}
				
		
		
	}
}
