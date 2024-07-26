package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;




@WebServlet("/deleteMember")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		MemberDAO member = new MemberDAO();
		
		
		  HttpSession session = request.getSession();	  		  
		  Member mem =(Member)session.getAttribute("info");
		  
		 try {
			if (member.deleteMember(mem.getId())) {
				session.invalidate();
				response.sendRedirect("/views/deleteMember.jsp");
				
				 
			 } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
